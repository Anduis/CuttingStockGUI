$javaFilePath = "c:/Users/amap/Actual/CuttingStockGUI/Scripting/Main.java"
$inputFolder = "c:/Users/amap/Actual/CuttingStockGUI/Scripting/sorted_txt"
$outputFolder = "c:/Users/amap/Actual/CuttingStockGUI/Scripting/outSorted"

# Crear la carpeta de salida si no existe
if (-not (Test-Path -Path $outputFolder)) {
    New-Item -ItemType Directory -Path $outputFolder
    Write-Host "Carpeta de salida creada: $outputFolder"
}

# Compilar Main.java
Write-Host "Compilando Main.java..."
javac $javaFilePath
Write-Host "Compilación completada."

# Obtener todos los archivos .txt en la carpeta de entrada
$txtFiles = Get-ChildItem -Path $inputFolder -Filter *.txt

# Ejecutar Main.java para cada archivo de entrada 10 veces y guardar la salida
foreach ($file in $txtFiles) {
    $outputFilePath = Join-Path -Path $outputFolder -ChildPath $file.Name
    Write-Host "Procesando archivo: $file.Name"
    for ($i = 1; $i -le 10; $i++) {
        Write-Host "  Ejecución $i para $file.Name"
        $input = Get-Content -Path $file.FullName
        $output = $input | java -Xms8g -Xmx14g -XX:+UseG1GC -XX:ParallelGCThreads=10 Main
        $output | Out-File -FilePath $outputFilePath -Append
    }
    Write-Host "  Procesamiento completado para $file.Name"
}

# Borrar todos los archivos .class
Write-Host "Eliminando archivos .class..."
Remove-Item -Path "c:/Users/amap/Actual/CuttingStockGUI/Scripting/*.class"
Write-Host "Archivos .class eliminados."