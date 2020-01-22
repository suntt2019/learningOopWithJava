#include <stdio.h>
int main()
{
	//获取参数方式 scanf
    //int x  =0;
    //int y = 0;
    //scanf("%d", &x);

    //结果输出使用prinf
    //printf("%d",x);

 	// 请在此添加你的代码
    /********** Begin *********/
	int A[]={1,4,6,9,11,25,31,46,83,100},n,ad=0;
	scanf("%d",&n);
	for(int i=0;i<10;i++)
		if(n>A[i])ad++;
	for(int i=0;i<10;i++){
		if(ad==i){
			printf("%d ",n);
			i--;
			ad=-1;
		}else{
			printf("%d ",A[i]);
		}

	}

	/********** End **********/


}