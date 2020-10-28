#include<stdio.h>
#include<string.h>
#include<stdlib.h>
void insert(FILE *fp);
void del(FILE *fp);
void modify(FILE *fp);
int search(FILE *fp,char*);
void display(FILE *fp);
void list(FILE *fp);
struct
{
    char name[50],branch[20];
    int roll,mobno,dob;
    char address[50];;
}student;
int main(void)
{
    char userid[20];
    char pswd[30];
    printf("\nEnter Username: ");
    fflush(stdin);
    scanf("%[^\n]s",userid);
    printf("Enter Password: ");
    fflush(stdin);
    scanf("%[^\n]s",pswd);
    if(strcmp(userid,"roshan") || strcmp(pswd,"2019PGCACA68"))
    {
        printf("\nWrong Username or Pasdword!");
        exit(1);
    }
    int choice;
    FILE *fp;
    fp=fopen("std","rb+");
    if(fp==NULL)
    {
        fp=fopen("std","wb+");
        if(fp==NULL)
        {
            puts("Error in opening file\n");
            exit(1);
        }
    }
    while(1)
    {
        printf("\n==========================::NIT JAMSHEDPUR::=======================");
        printf("\n*******************::STUDENT MANAGEMENT SYSTEM::*******************");
        printf("\n1. Insert New Student\n");
        printf("2. Delete a student record\n");
        printf("3. Display a Student Details\n");
        printf("4. Modify an existing Student record\n");
        printf("5. List of all Student\n");
        printf("6. Clear Screen\n");
        printf("7. Exit\n");
        printf("Enter your choice: ");
        scanf("%d",&choice);

        switch(choice)
        {
        case 1:
            insert(fp);
            break;
        case 2:
            del(fp);
            break;
        case 3:
            display(fp);
            break;
        case 4:
            modify(fp);
            break;
        case 5:
            list(fp);
            break;
        case 6:
            system("CLS");
            break;
        case 7:
            fclose(fp);
            exit(1);
        default:
            printf("Wrong choice!\n");
        }
    }
}
void insert(FILE *fp)
{
    fseek(fp,0,2);
    printf("Enter Student Name: ");
    fflush(stdin);
    scanf("%[^\n]s",student.name);
    printf("Enter Branch: ");
    fflush(stdin);
    scanf("%[^\n]s",student.branch);
    printf("Enter Student Roll: ");
    fflush(stdin);
    scanf("%d",&student.roll);
    printf("Enter Student Mobile no: ");
    fflush(stdin);
    scanf("%d",&student.mobno);
    printf("Enter Student DOB: ");
    fflush(stdin);
    scanf("%d",&student.dob);
    printf("Enter Address : ");
    scanf("%[^\n]s",&student.address);
    fwrite(&student,sizeof(student),1,fp);
}
void del(FILE *fp)
{
    FILE *fptmp;
    char name[20];
    printf("Enter the name of Student to be deleted from database: ");
    fflush(stdin);
    scanf("%[^\n]s",name);
    if(search(fp,name)==0)
        return ;
    fptmp=fopen("tempfile","wb");
    rewind(fp);
    while(fread (&student, sizeof (student),1,fp)==1)
    {
        if (strcmp(name,student.name)!=0)
            fwrite(&student,sizeof(student),1,fptmp);

    }
    fclose(fp);
    fclose(fptmp);
    remove("std");
    rename("tempfile","std");
    printf("\nRecord deleted..\n\n");
    fp=fopen("std","rb+");

}
void modify(FILE *fp)
{
    char name[50];
    long size=sizeof(student);
    printf("Enter Name of the Student to be modified: ");
    fflush(stdin);
    scanf("%[^\n]s",name);
    if(search(fp,name)==1)
    {
        printf("Enter New Information-->\n");
        printf("Enter Student Name: ");
        fflush(stdin);
        scanf("%[^\n]s",student.name);
        printf("Enter Branch: ");
        fflush(stdin);
        scanf("%[^\n]s",student.branch);
        printf("Enter Student Roll: ");
        fflush(stdin);
        scanf("%d",&student.roll);
        printf("Enter Student Mobile no: ");
        fflush(stdin);
        scanf("%d",&student.mobno);
        printf("Enter Student DOB: ");
        fflush(stdin);
        scanf("%d",&student.dob);
        printf("Enter Address: ");
        scanf("%[^\n]s",&student.address);
        fseek(fp,-sizeof(student),1);
        fwrite(&student,sizeof(student),1,fp);
        printf("\nRecord successfully modified\n\n");
    }
}
void display(FILE *fp)
{

    char name[50];
    printf("Enter the name of the Student: ");
    fflush(stdin);
    scanf("%[^\n]s",name);
    if(search(fp,name)==1)
    {
        printf("\n\t::NAME::\t\t::BRANCH::\t::ROLL::\t::ADDRESS::\t::MOBILE NO::\tDATE OF BIRTH\n\n");
        printf("\t%s",student.name);
        printf("\t\t  %s",student.branch);
        printf("\t\t\t  %d",student.roll);
        printf("\t\t\t  %d",student.mobno);
        printf("\t\t\t  %d",student.dob);
        printf("\t\t\t  %s",student.address);

    }
}
int  search(FILE *fp, char *name)
{
    unsigned flag=0;
    rewind(fp);
    while(fread(&student,sizeof(student),1,fp)==1)
    {
        if(strcmp(name,student.name)==0)
        {
            flag=1;
            break;
        }
    }
    if(flag==0)
        printf("\nName not found in file\n\n");
    return flag;
}
void  list(FILE *fp)
{
    rewind(fp);
    printf("\n\t::NAME::\t::BRANCH::\t::ROLL::\t::ADDRESS::\t::MOBIL NO::\t::DATE OF BIRTH\n\n");
while(fread(&student,sizeof(student),1,fp)==1)
{
    printf("\t%s",student.name);
    printf("\t\t  %s",student.branch);
    printf("\t\t\t  %d",student.roll);
    printf("\t\t\t  %d",student.mobno);
    printf("\t\t\t  %d",student.dob);
    printf("\t\t\t  %s",student.address);
    printf("\n");
}


}

