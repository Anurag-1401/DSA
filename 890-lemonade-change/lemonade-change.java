class Solution 
{
    public boolean lemonadeChange(int[] bills) 
    {
        int five = 0;
        int ten = 0;

        for(int bill:bills)
        {
            if(bill == 20)
            {
                 if(ten >= 1 && five>=1)
                {
                    ten -= 1;
                    five -= 1;
                }else if(five >= 3)
                {
                    five -= 3;
                }else{
                    return false;
                }
            }else if(bill == 10)
            {
                if(five >= 1)
                {
                    five -= 1;
                }else{
                    return false;
                }
                ten++;
            }else{
                five++;
            }
        }

        return true;
    }
}