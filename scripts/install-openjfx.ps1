# Define URL e caminhos
$zipUrl = "https://download2.gluonhq.com/openjfx/24/openjfx-24_windows-x64_bin-sdk.zip"

# Caminho absoluto da pasta do projeto (um nível acima do script)
$projectRoot = Resolve-Path "$PSScriptRoot\.."
$zipFile = "$PSScriptRoot\openjfx.zip"
$extractPath = Join-Path $projectRoot "tools"

# Cria a pasta tools se não existir
if (-not (Test-Path $extractPath)) {
    New-Item -ItemType Directory -Path $extractPath | Out-Null
}

# Faz o download do ZIP
Write-Host "Baixando OpenJFX..."
Invoke-WebRequest -Uri $zipUrl -OutFile $zipFile

# Extrai o conteúdo
Write-Host "Extraindo para a pasta tools..."
Expand-Archive -Path $zipFile -DestinationPath $extractPath -Force

# Remove o arquivo ZIP após extração
Remove-Item $zipFile

Write-Host "Concluido! OpenJFX extraido para: $extractPath"
