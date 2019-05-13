//
// Created by Sebastian Nielebock on 03.04.2019.
//

#include <stdio.h>

/*
 *       *
 *      ***
 *     *****
 *    *******
 *       *
 */

void print_tree_char(int height, char sym){
    int startSpaces = height-1;
    int numSpaces = startSpaces;
    int numSym = 1;
    int i;
    for(i = 0; i<height;i++){
        int sp, sy;
        for(sp = 0; sp < numSpaces;sp++){
            printf(" ");
        }
        for(sy = 0; sy < numSym; sy++){
            printf("%c",sym);
        }
        numSpaces--;
        numSym+=2;
        printf("\n");
    }
    int lsp;
    for(lsp = 0; lsp < startSpaces;lsp++){
        printf(" ");
    }
    printf("*\n\n");
}

void print_tree(int height){
    print_tree_char(height, '*');
}

int main(void){
    print_tree(5);
    print_tree_char(5,'o');
    return 0;
    print_tree(1);
    print_tree(2);
    print_tree(3);
    print_tree(4);
    print_tree(10);
    print_tree_char(10,'+');
    print_tree_char(10,'o');
    return 0;
}