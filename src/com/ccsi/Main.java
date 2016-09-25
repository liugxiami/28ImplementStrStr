package com.ccsi;

public class Main {

    public static void main(String[] args) {
	    String a="abcdefgh";
        String b="afg";
        System.out.println(strStr(a,b));
    }
    //Implement strStr();
    //Returns the index of the first occurrence of needle in haystack. or-1 if needle is not part of haystach.
    public static int strStr(String haystack,String needle){
        if(haystack==null||needle==null||haystack.length()<needle.length())return -1;
        int hlen=haystack.length();
        int nlen=needle.length();
        int p=0,q=0;
        while(p<hlen&&q<nlen){
            while(haystack.charAt(p)!=needle.charAt(q)){
                p++;
                if(p==hlen)return -1;
            }
            while (q<nlen&&p<hlen&&haystack.charAt(p)==needle.charAt(q)){
                p++;
                q++;
            }
            if(q==nlen){
                return p-q;
            }else{
                p=p-q+1;
                q=0;
            }
        }
        return -1;
    }
    //2.利用substrate（）方法
    public static int strStr1(String haystack,String needle){
        if(haystack==null)return -1;
        if(needle==null)return 0;
        if(needle.length()>haystack.length())return -1;
        int hlen=haystack.length();
        int nlen=needle.length();
        for (int i = 0; i+nlen <= hlen; i++) {
            String temp=haystack.substring(i,i+nlen);
            if(temp.contentEquals(needle)){
                return i;
            }
        }
        return -1;
    }
}
