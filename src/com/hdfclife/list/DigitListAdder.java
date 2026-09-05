package com.hdfclife.list;

public class DigitListAdder {
    public static ClaimNode add(ClaimNode first,ClaimNode second){
        ClaimNode dummy=new ClaimNode(0);
        ClaimNode current=dummy;
        int carry=0;

        while (first!=null || second!=null ||carry!=0){
            int digit1=0;
            int digit2=0;

            if(first!=null){
                digit1=first.getAmount();
                first =first.getNext();
            }
            if (second != null) {
                digit2 = second.getAmount();
                second = second.getNext();
            }

            int sum=digit1+digit2+carry;

            int digit = sum%10;
            carry = sum/10;

            current.setNext(new ClaimNode(digit));
            current=current.getNext();

        }
        return dummy.getNext();
    }
}
