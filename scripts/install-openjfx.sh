#!/bin/bash

# Detecta o sistema operacional
OS_TYPE="$(uname -s)"
ARCH_TYPE="$(uname -m)"
ZIP_URL=""

# Define a URL correta com base no sistema operacional
if [[ "$OS_TYPE" == "Linux" ]]; then
  ZIP_URL="https://download2.gluonhq.com/openjfx/24/openjfx-24_linux-x64_bin-sdk.zip"
elif [[ "$OS_TYPE" == "Darwin" && "$ARCH_TYPE" == "arm64" ]]; then
  ZIP_URL="https://download2.gluonhq.com/openjfx/24/openjfx-24_osx-aarch64_bin-sdk.zip"
else
  echo "Sistema operacional não suportado ou arquitetura desconhecida: $OS_TYPE / $ARCH_TYPE"
  exit 1
fi

# Caminhos
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
ZIP_FILE="$SCRIPT_DIR/openjfx.zip"
EXTRACT_PATH="$PROJECT_ROOT/tools"

# Cria a pasta tools se não existir
if [ ! -d "$EXTRACT_PATH" ]; then
  mkdir -p "$EXTRACT_PATH"
fi

# Faz o download do ZIP
echo "Baixando OpenJFX de: $ZIP_URL"
curl -L -o "$ZIP_FILE" "$ZIP_URL"

# Extrai o conteúdo do ZIP
echo "Extraindo para a pasta tools..."
unzip -o "$ZIP_FILE" -d "$EXTRACT_PATH"

# Remove o arquivo ZIP
rm "$ZIP_FILE"

echo "Concluído! OpenJFX extraído para: $EXTRACT_PATH"
