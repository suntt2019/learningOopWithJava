#include <iostream>
#include <time.h>
#include <string.h>
#define MAX 1000000
#define CNT 10000
using namespace std;

int A[MAX]={0}, B[MAX], test[CNT];
struct S{
    int C[MAX];
}SA,SB;

void copy_for1() {
    for (int j = 0; j < CNT; ++j) {
        for (int i = 0; i < MAX; ++i)
            B[i] = A[i];
    }
    return;
}
void copy_for2() {
    for (int j = 0; j < CNT; ++j) {
        for (int i = 0; i < MAX; ++i)
            B[i] = A[i];
    }
    return;
}
void copy_while() {
    for (int j = 0; j < CNT; ++j) {
        int i=0;
        while(i<MAX){
            B[i]=A[i];
            ++i;
        }
    }
    return;
}
void copy_struct() {
    for (int j = 0; j < CNT; ++j) {
       SB=SA;
   }
}
void copy_memcpy() {
    for (int j = 0; j < CNT; ++j) {
       memcpy(A,B,sizeof(int)*MAX);
   }
}


int main() {
    long t0;
    void ((*pf[])()) = {copy_for1,copy_for2,copy_while,copy_struct,copy_memcpy};
    char name[][10]={" for1   "," for2   "," while  "," struct "," memcpy "};
    for(int i=0;i<MAX;i++){
        SA.C[i]=1;
        SB.C[i]=2;
    }
    for(int k=0;k<5;k++){
        for(int i=0;i<MAX;i++){
            A[i]=1;
            B[i]=2;
        }
        //cout<<"[start]"<<endl;
        t0 = time(NULL);
            pf[k]();
        t0 -= time(NULL);
        //cout<<"[end]"<<endl;
        cout << "time-" << name[k] << t0 << "s" << endl;
    }
    return 0;
}

/*
测试输出如下：
time- for1   -37s
time- for2   -45s
time- while  -46s
time- struct -4s
time- memcpy -6s
说明：
两个for是因为之前测试多组一样方法的时候发现第一组测试的会时间不太一样（可能是CPU温度缘故）
如果您再次测试这个代码的时候时间整体较快，那很正常，主要因为上面测试用的电脑太菜了(intel m5)
*/