#!/bin/zsh

folders=$(find . -maxdepth 1 -type d -regex './c[0-9|_]*')

echo ""
sum=0
for folder in $folders
do
  folder=${folder#./} # 去掉前面的./
  count=$(find "$folder" -mindepth 1 -maxdepth 1 -type d | wc -l)
  ((sum+=count))
  printf "%-10s%15s\n" "$folder" "$count 题"
done

printf "%24s\n" "---------------"
printf "%26s\n" "共 $sum 题"
echo ""