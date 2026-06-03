file_info(){
echo "file name: $1"
echo "line num: $(wc -l < "$1")"
echo "word number: $(wc -w < "$1")"
}

file_info j1.sh

math(){
echo "first number=$1"
echo "Second number="$2"
}

math 10 5
