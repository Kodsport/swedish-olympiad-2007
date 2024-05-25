#include <stdio.h>
#include <string.h>

int main(){
  char ord[100],m;
  int nb,i,j,k,n;

  scanf("%s",ord);
  nb=strlen(ord);
  scanf("%d", &n);
  for(i=0;i<nb-1 && n>=0;i++) {   //Loopa över positionerna så länge det finns omflyttningar kvar
    //Följande rader bestämmer den lägsta bokstav m som är inom räckhåll för framflyttning till aktuell position
    m='Z'+1;   //Starta med en oändligt hög bokstav
    k=-1;
    for(j=i;j<nb && j-i<=n;j++){  //Observera att ingen omflyttning, alltså fallet j=i, alltid är ett alternativ
      if(ord[j]<m) {
        m=ord[j]; 
        k=j;
      }
    }

    for(j=k;j>i;j--) ord[j]=ord[j-1]; //Flytta om bokstäverna
    ord[i]=m;
    n -= k-i; //Minska antalet tillgängliga omflyttningar
  }
  printf("%s\n", ord);
  return 0;
};
