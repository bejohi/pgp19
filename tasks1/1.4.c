 /*
a) Schreiben Sie eine Prozedur void print_tree(int height), die einen  symmetrischen Baum, mit der Höhe height auf der Konsole ausgibt. So würde der Aufruf print_tree(5) folgenden Baum ergeben:
    *
   ***
  ***** 
 *******
*********
    *

b) Ergänzen Sie Ihre Methode print_tree zu einer Prozedur void print_tree_char(int height, char sym), die das Symbol aus dem der Baum besteht durch ein beliebiges Symbol sym ersetzt. So würde ein Aufruf print_tree_char(5,'o') folgenden Baum ergeben:
 */

#include <stdio.h>
#include <math.h>

void print_tree(int height);
void print_tree_char(int height, char sym);

int main(int argc, char* argv[]){
    print_tree(5);
    print_tree_char(10,'x');
    return 0;
}

void print_tree(int height){
    print_tree_char(height,'*');
}

void print_tree_char(int height, char sym){
    for(int i = 0; i < height; i++){
        for(int x = 0; x < height-i;x++){
            printf(" ");
        }
        for(int x = 0; x < 2*i+1;x++){
            printf("%c",sym);
        }
        printf("\n");
    }
    for(int x = 0; x < height;x++){
            printf(" ");
    }
    printf("*");
    printf("\n");
}


