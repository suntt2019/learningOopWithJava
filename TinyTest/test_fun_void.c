#include <stdio.h>
int fun(void);

int main(){
	printf("in main\n");
	printf("%d\n",fun(2));
	return 0;
}

int fun(int x){
	printf("In fun()\n");
	return 2*x;
}