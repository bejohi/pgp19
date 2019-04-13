/*
a) Definieren Sie einen Datentyp smartphone_t als struct, der die Marke (brand) als String (char*), das Modell (model) als String (char*), die Farbe (color) als String (char*) und den Speicher in GB (memory) als Integer-Wert (int) speichert. 
b) Erstellen Sie eine Prozedur void print_smartphone_configuration(smartphone_t phone), das die Konfiguration eines smartphone_t Datentypes auf der Konsole ausgibt.
c) Erstellen Sie eine Prozedur void add_additional_sd_card(smartphone_t* phone), die den Gesamtspeicher um 128GB erhöht. So ergibt mit dem in b) angelegten struct phone die Aufrufe
*/

#include <stdio.h>

typedef struct smartphone_t {
    char* brand;
    char* model;
    char* color;
    int memory;
} smartphone_t;

void print_smartphone_configuration(smartphone_t phone);
void add_additional_sd_card(smartphone_t* phone);

int main(){
    smartphone_t samsung = {
        .brand = "Samsung",
        .model = "Galaxy 1",
        .color = "white",
        .memory = 6
    };
    print_smartphone_configuration(samsung);
    add_additional_sd_card(&samsung);
    print_smartphone_configuration(samsung);
    return 0;
}

void print_smartphone_configuration(smartphone_t phone){
    printf("Your configuration \n");
    printf("\tBrand: %s \n",phone.brand);
    printf("\tModel: %s \n",phone.model);
    printf("\tColor: %s \n",phone.color);
    printf(" Total Memory: %d \n",phone.memory);
}

void add_additional_sd_card(smartphone_t* phone){
    phone->memory = phone->memory+128;
}