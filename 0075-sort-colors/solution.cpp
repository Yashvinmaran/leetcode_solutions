class Solution {
public:
    void sortColors(vector<int>& nums) {
        divides(nums,0,nums.size()-1);
        print(nums,nums.size());
    }
        void merge(vector<int> &arr, int low, int mid, int high){
        vector<int>newarr;
        int i = low;
        int j = mid+1;

        while(i<=mid && j<=high){
            if(arr[i]<arr[j]){
                newarr.push_back(arr[i]);
                i++;
            }else{
                newarr.push_back(arr[j]);
                j++;
            }
        }
        while(i<=mid){
            newarr.push_back(arr[i]);
            i++;
        }
        while(j<=high){
            newarr.push_back(arr[j]);
            j++;
        }
        for (int k = low; k<=high; k++){
            arr[k] = newarr[k-low];
        }
    }
        void divides(vector<int>&arr, int low, int high){
            if(low<high){
                int mid = (low+high)/2;
                divides(arr,low,mid);
                divides(arr,mid+1,high);
                merge(arr,low,mid,high);
            }
        }
        void print(vector<int>&arr,int size){
            for (int i = 0; i<size; i++){
                cout<<arr[i] << " ";
            }
        }
};
