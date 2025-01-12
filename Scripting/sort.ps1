$inputFolder = "c:/Users/amap/Actual/CuttingStockGUI/Scripting/txt"
$outputFolder = "c:/Users/amap/Actual/CuttingStockGUI/Scripting/sorted_txt"

# Crear la carpeta de salida si no existe
if (-not (Test-Path -Path $outputFolder)) {
    New-Item -ItemType Directory -Path $outputFolder
    Write-Host "Carpeta de salida creada: $outputFolder"
}

# Obtener todos los archivos .txt en la carpeta de entrada
$txtFiles = Get-ChildItem -Path $inputFolder -Filter *.txt

foreach ($file in $txtFiles) {
    $lines = Get-Content -Path $file.FullName
    $firstLine = $lines[0]
    $lastLine = $lines[-1]
    $middleLines = $lines[1..($lines.Length - 2)]

    # Ordenar las líneas intermedias por el segundo número en orden decreciente
    $sortedLines = $middleLines | Sort-Object { [int]($_ -split ' ')[1] } -Descending

    # Crear el contenido final
    $outputContent = @($firstLine) + $sortedLines + $lastLine

    # Guardar el contenido ordenado en un nuevo archivo en la carpeta de salida
    $outputFilePath = Join-Path -Path $outputFolder -ChildPath $file.Name
    $outputContent | Out-File -FilePath $outputFilePath

    Write-Host "Archivo procesado: $file.Name"
}