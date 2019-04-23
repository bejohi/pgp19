#include <stdio.h>
#include <stdlib.h>

typedef struct{
    char* array;
    int numElems;
    int size;
}Dyn_array_t;

void initArray(Dyn_array_t* array, int desSize){
    array->array = malloc(sizeof(char) * desSize);
    array->size = desSize;
    array->numElems = 0;
}

void destroyArray(Dyn_array_t* array){
    free(array->array);
    array->array = NULL;
    array->size = 0;
}

void insert(Dyn_array_t* array, char elem){
    if(array->numElems >= array->size){
        char* newArr = malloc(array->size * 2 * sizeof(char));
        for(int i = 0; i < array->size;i++){
            newArr[i] = array->array[i];
        }
        free(array->array);
        array->array = newArr;
        array->size *= 2;
    }

    array->array[array->numElems] = elem;
    array->numElems++;
}

int main() {
    Dyn_array_t arr = {};
    initArray(&arr,100);
    insert(&arr,'a');
    printf("%d %d\n",arr.numElems,arr.size);
   return EXIT_SUCCESS;
}