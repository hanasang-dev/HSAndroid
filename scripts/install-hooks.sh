#!/bin/bash

HOOK_NAMES=(
  "commit-msg"
  "pre-commit"
)

echo "🚀 Installing Git Hooks..."

# core.hooksPath 설정 검사
HOOK_PATH=$(git config --get core.hooksPath)

if [ -n "$HOOK_PATH" ]; then
  echo "❌ Detected custom core.hooksPath: $HOOK_PATH"
  echo "This project uses the default .git/hooks directory."
  echo "Unset it with: git config --unset core.hooksPath"
  exit 1
fi

# hooks 디렉토리 없으면 생성
if [ ! -d ".git/hooks" ]; then
  echo "📂 .git/hooks directory not found. Creating..."
  mkdir -p .git/hooks
fi

for hook in "${HOOK_NAMES[@]}"
do
  src="./scripts/hooks/$hook"
  dest=".git/hooks/$hook"

  if [ -f "$src" ]; then
    ln -sf "../../$src" "$dest"
    chmod +x "$src"
    echo "✅ Linked $hook hook"
  else
    echo "⚠️  Skip $hook (not found at $src)"
  fi
done

echo "🎉 Git Hooks installation completed."

exit 0