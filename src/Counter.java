/*
 * The class and function to find and return missing value.
 * This runs in O(N).
 */

class Counter 
{
	public int getMissing(int[] A) 
    {
        int min = A[0]; //Set Min to First Element
        int max = A[0]; //Set Max to First Element
        int [] counts; //Array to Hold Counts of Numbers
        int j; //To Traverse counts Array
        
        if (A.length>1) //If More Than 1 Element in Array
        {
            for (int i=1; i<A.length; i++) //Loop From 2nd Till Last Element
            {
            	if (A[i]<min && A[i]>0) //Looking Only for Minimal Positive
                    min = A[i]; //Change If Number is Smaller Than min But More Than Zero
            	else if (min<1 && A[i]>0) //First Element May Happen to be A Negative Number
                    min = A[i];	//If Current min is Negative or 0, Change to Number if Number is Positive
                if (A[i]>max && A[i]<=100000) //Compare Current max With Number (Edge Accounted for)
                    max = A[i]; //Change if Number is More Than Max, but Less Than or Equal to Edge
                else if (max>100000 && A[i]<=100000)//Compare Current max With Number (Edge Accounted for)
                    max = A[i];//Change if Number
            }
        }
        
        /*
         * This problem has a couple of edges. The first being the minimum, which has to be at least 1.
         * The size of array A is at most 100,000. So even though it can contain values higher, if it does
         * 		that means there must be a positive integer between 1 and 100,000 missing, 
         * 		thus making the rest of the array irrelevant.
         * This means the only max needed is the greatest number that is no bigger than 100,000.
         */
        
        //Edge Cases
        if (min>1 || max<1) //No Positive Integers in Array or No "1" in Array
            return 1; //Missing Integer Must be 1
        else if (min==max)
            return 2; //If Here, All Values Must be 1, 2 is Next Missing
        
        counts = new int [max]; //Make Array of counts With Size of max Number in Array
        
        for (int i=0; i<A.length; i++) //Loop through Array A
        {
            if (A[i]>0 && A[i]<=max) //If Value is Positive but Less Than max (Array has Different Range for Elements)
                counts[A[i]-1]++; //Keep Count
        }
        
        for (j=0; j<counts.length; j++) //Loop Through Array of counts
        {
            if (counts[j]==0) //Break After Finding First 0
                break;
        }
        
        if(j==counts.length) //If j Traversed Through Full Array
            return (++max); //Sequence is A Permutation, Return Next Element in Permutation
        else
            return (++j); //Return Index Plus One (Adjusting for Zero Index)
    }
}
