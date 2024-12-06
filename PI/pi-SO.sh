#!/bin/sh

# Função para exibir a versão do sistema operacional
function show_os_version() {
  echo "Versão do Sistema Operacional:"
  cat /etc/os-release | grep -w "PRETTY_NAME" | cut -d= -f2 | tr -d '"'
  echo
}

# Função para exibir a quantidade de memória
function show_memory() {
  echo "Quantidade de Memória:"
  free -h | awk '/Mem:/ {print "Total: " $2 ", Usada: " $3 ", Livre: " $4}'
  echo
}

# Função para exibir a quantidade de disco
function show_disk() {
  echo "Quantidade de Disco:"
  df -h --total | awk '/total/ {print "Total: " $2 ", Usado: " $3 ", Disponível: " $4}'
  echo
}

# Função para exibir a versão do kernel
function show_kernel_version() {
  echo "Versão do Kernel:"
  uname -r
  echo
}

# Função para exibir os usuários logados no sistema
function show_logged_users() {
  echo "Usuários Logados:"
  who
  echo
}

# Menu interativo
while true; do
  echo "-------------------------------"
  echo "         MENU PRINCIPAL        "
  echo "-------------------------------"
  echo "1. Mostrar versão do sistema operacional"
  echo "2. Mostrar quantidade de memória"
  echo "3. Mostrar quantidade de disco"
  echo "4. Mostrar versão do kernel"
  echo "5. Mostrar usuários logados"
  echo "6. Sair"
  echo "-------------------------------"
  read -p "Escolha uma opção: " option

  case $option in
  1) show_os_version ;;
  2) show_memory ;;
  3) show_disk ;;
  4) show_kernel_version ;;
  5) show_logged_users ;;
  6)
    echo "Saindo..."
    exit 0
    ;;
  *) echo "Opção inválida! Por favor, tente novamente." ;;
  esac
  echo
done
