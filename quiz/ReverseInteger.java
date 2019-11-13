class ReverseInteger {
    public static void main(String[] args) {
    	int result = reverse(123456789);
    	System.out.println(result);
    }

    static int reverse(int x) {
        int result = 0;

        while(x != 0) {
            result = result * 10 + (x % 10);
            x /= 10;
        }

        return result;
    }
}