import java.util.Random;


class OrdArray {
	private long[] a;
	private int nElems;


	// -----------------------------
	public OrdArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	// ------------------------------
	public int size() {
		return nElems;
	}

	// -------------------------------
	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;

		while (true) {
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn] == searchKey)
				return curIn;
			else if (lowerBound > upperBound)
				return nElems;
			else {
				if (a[curIn] < searchKey)
					lowerBound = curIn + 1;
				else
					upperBound = curIn - 1;
			}
		}
	}
	
	//-------------------------------------
	public long[] insert(long value){
		int j=0;
		for(j=0;j<nElems;j++)
		if(a[j]> value)
		break;
			for(int k=nElems;k>j;k--)
			a[k]=a[k-1];
		
		a[j]=value;
		nElems++;
		return a;
		
	}
	
	
	//-----------------------------------------
	public boolean delete(long value){
		int k = find(value);
		if(k==nElems)
			return false;
		else
		{
			for(int j =k;j<nElems;j++)
				a[j]=a[j+1];
			nElems--;
			return true;
		}
	}
	
	//----------------------------------------------
	public void display(){
		for(int i=0;i<nElems;i++)
			System.out.print(a[i]+" ");
		System.out.println(" ");
		
	}
	
	//-----------------MERGE() METHOD------------------------------
	
	public void merge(long[] arr1, long[] arr2,int k1, int k2){
		int i=0;
		int j=0;
		int k=0;
		long[] arr = new long[k1+k2];
		
		while(i<k1 && j<k2){
			if(arr1[i] <= arr2[j]){
				arr[k] = arr1[i];
				k++;
				i++;
			}else{
				arr[k] = arr2[j];
				k++;
				j++;
			}
		}
		if(i != k1)
			while(i < k1){
				arr[k] = arr1[i];
				k++;
				i++;
			}
		else
			while(j < k2){
				arr[k] = arr2[j];
				k++;
				j++;
		}
		for(int p=0;p<(k1+k2);p++)
			System.out.print(arr[p]+" ");
		System.out.println(" ");
	}
	

}

//---------------------------MAIN PROGRAM------------------------------------------------------

public class OrderedApp {
	public static void main(String[] args) {
		int maxSize = 100;
		OrdArray arr;
		arr = new OrdArray(maxSize);
		
		arr.insert(98);
		arr.insert(12);
		arr.insert(100);
		arr.insert(56);
		arr.insert(87);
		arr.insert(90);
		arr.insert(34);
		arr.insert(89);
		arr.insert(9);
		arr.insert(65);
			
		
		arr.display();
		
		int searchKey = 56;
		if(arr.find(searchKey)!=arr.size())
			System.out.println("Found: "+searchKey);
		else
			System.out.println("Not Found: "+searchKey);
		
		arr.delete(89);
		arr.delete(12);
		arr.delete(87);
		
		
		arr.display();
		
		
		OrdArray arr1;
		arr1 = new OrdArray(maxSize);
		
		OrdArray arr2;
		arr2 = new OrdArray(maxSize);
		
		//-------------RANDOM NUMBERS----------------------------------------------
		
		int k1 = (int) (Math.random()*(maxSize/10));//random size for array with max bound being maxSize/10
		int k2 = (int) (Math.random()*(maxSize/10));
		long[] tempArr1;
		long[] tempArr2;
		tempArr1 = new long[k1];
		tempArr2 = new long[k2];
		
		for(int i=0;i<k1;i++){
			Random rand = new Random();
			tempArr1 = arr1.insert(rand.nextInt(200));
			
					}
		
		for(int i=0;i<k2;i++){
			long random = (long) (Math.random()*100);
			tempArr2 = arr2.insert(random);
		}
		//---------------------------------------------
			
			
		
		
		arr1.display();
		arr2.display();
		
		OrdArray arr3;
		arr3 = new OrdArray(maxSize);
	
		arr3.merge(tempArr1, tempArr2,k1,k2);
		
		
		
		
		
		//-------------------------------------------------
		
			
	}
}
