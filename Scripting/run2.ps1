$javaFilePath = "c:/Users/amap/Actual/CuttingStockGUI/Scripting/Main.java"
$inputFolder = "c:/Users/amap/Actual/CuttingStockGUI/Scripting/txt"
$outputFolder = "c:/Users/amap/Actual/CuttingStockGUI/Scripting/out"
$fileName = "10.txt"

# Crear la carpeta de salida si no existe
if (-not (Test-Path -Path $outputFolder)) {
    New-Item -ItemType Directory -Path $outputFolder
}

# Compilar Main.java
javac $javaFilePath

# Ruta completa del archivo de entrada
$inputFilePath = Join-Path -Path $inputFolder -ChildPath $fileName
# Ruta completa del archivo de salida
$outputFilePath = Join-Path -Path $outputFolder -ChildPath $fileName

# Ejecutar Main.java para el archivo de entrada y guardar la salida
for ($i = 1; $i -le 10; $i++) {
        $input = Get-Content -Path $inputFilePath
        $output = $input | java -Xms512m -Xmx4g -XX:+UseG1GC -XX:ParallelGCThreads=4 Main
        $output | Out-File -FilePath $outputFilePath -Append
    }

# Borrar todos los archivos .class
Remove-Item -Path "c:/Users/amap/Actual/CuttingStockGUI/Scripting/*.class"