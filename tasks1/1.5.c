/*
a) Schreiben Sie eine Prozedur int is_prime(int num), die für eine Zahl num bestimmt, ob sie eine Primzahl ist. Dabei soll der Rückgabewert 0 das logische False bzw. ein Wert ungleich von 0 das logische True repräsentieren.

b) Schreiben Sie basierend auf Ihrer Prozedur is_prime eine Prozedur int calculate_nth_prime_number(int n), die die n'te Primzahl als Rückgabewert zurückgibt. Bedenken Sie, dass die Zahl 1 keine Primzahl ist.

Hinweis: Zum Prüfen der Primzahl sind die Methoden der Bibliothek math.h hilfreich. (#include <math.h>)
*/

#include <stdio.h>

int is_prime(int num);
int calculate_nth_prime_number(int n);

int main(){
    int n_prime = calculate_nth_prime_number(1);
    printf("%d",n_prime);

    return 0;
}

int is_prime(int num){
    if(num <= 1){
        return 0; 
    }

    if(num == 2){
        return 1;
    }

    for(int i = 2; i < num;i++){ // TODO: Optimze with sqrt
        if(num % i == 0){
            return 0;
        }
    }

    return 1;
}

int calculate_nth_prime_number(int n){
    if(n <= 0){
        return 0;
    }
    int alreadyFound = 0;
    int i = 1;
    while(alreadyFound < n){
        i++;
        if(is_prime(i)){
            alreadyFound++;
        }
    }
    return i;
}