package com.十_正则表达式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("a","ab*"));
    }
    Boolean[][] dtgh=null;

    public boolean isMatch(String s, String p) {
       char[] ps=p.toCharArray();
        List<Character[]> plist=new ArrayList<>(ps.length);
        for (char v:ps){
            if(v=='*'&&plist.size()>0){
                    plist.get(plist.size()-1)[1]='*';
            }else{
                plist.add(new Character[]{v,' '});
            }
        }
        dtgh=new Boolean[s.length()+1][plist.size()+1];
        return ism(s.toCharArray(),plist,0,0);
    }

    public boolean ism(char[] s,List<Character[]> p,int si,int pi){
        Boolean returnval=null;
        if(dtgh[si][pi]!=null){
            return dtgh[si][pi];
        }
        if(si<s.length&&pi<p.size()){
            if('*'==p.get(pi)[1]){
                if(p.get(pi)[0]=='.'||p.get(pi)[0]==s[si]){
                    boolean isuse=ism(s,p,si+1,pi);
                    if(isuse){
                        returnval= true;
                    }else{
                        isuse= ism(s,p,si,pi+1);
                        if(isuse){
                            returnval= true;
                        }else{
                            returnval= ism(s,p,si+1,pi+1);
                        }
                    }

                }else{
                    returnval= ism(s,p,si,pi+1);
                }
            }else{
                if(p.get(pi)[0]=='.'||p.get(pi)[0]==s[si]){
                    returnval= ism(s,p,si+1,pi+1);
                }else{
                    returnval= false;
                }
            }
        }else if(pi<p.size()&&'*'==p.get(pi)[1]){
            returnval=  ism(s,p,si,pi+1);
        }else if(si==s.length&&pi==p.size()){
            returnval= true;
        }else{
            returnval= false;
        }
        dtgh[si][pi]=returnval;
        return returnval;
    }
}