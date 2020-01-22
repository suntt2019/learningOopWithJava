#include <stdio.h>
int fun(int);

int main(){
	printf("in main\n");
	printf("%d",fun(2));
	return 0;
}

int fun(int x){
	printf("In fun()\n");
	return 2*x;
}