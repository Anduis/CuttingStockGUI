$sourceFolder = "c:/Users/amap/Actual/CuttingStockGUI/Scripting/json"
$destinationFolder = "c:/Users/amap/Actual/CuttingStockGUI/Scripting/txt"

# Crear la carpeta de destino si no existe
if (-not (Test-Path -Path $destinationFolder)) {
    New-Item -ItemType Directory -Path $destinationFolder
}

# Obtener todos los archivos JSON en la carpeta de origen
$jsonFiles = Get-ChildItem -Path $sourceFolder -Filter *.json

foreach ($file in $jsonFiles) {
    # Leer el contenido del archivo JSON
    $jsonContent = Get-Content -Path $file.FullName | Out-String | ConvertFrom-Json

    # Crear una lista para almacenar las líneas de texto
    $lines = @()

    foreach ($item in $jsonContent.Objects) {
        $line = "$($item.Length) $($item.Height)"
        $lines += $line
    }
    # Extraer los valores de Length y Height de cada objeto en Items
    foreach ($item in $jsonContent.Items) {
        for ($j = 1; $j -le $item.Demand; $j++) {
        $line = "$($item.Length) $($item.Height)"
        $lines += $line
        }
    }
        $lines += "e"

    # Crear el archivo de texto en la carpeta de destino
    $txtFileName = [System.IO.Path]::ChangeExtension($file.Name, ".txt")
    $txtFilePath = Join-Path -Path $destinationFolder -ChildPath $txtFileName

    # Escribir las líneas en el archivo de texto
    $lines | Out-File -FilePath $txtFilePath
}