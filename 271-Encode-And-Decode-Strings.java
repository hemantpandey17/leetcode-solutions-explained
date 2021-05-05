public class Codec {
    
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            i = slash + size + 1;
            ret.add(s.substring(slash + 1, i));
        }
        return ret;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));

/*
Here how it works
dummy_input = ["Hello","World"]

Now when encode is called
We make a StringBuilder, now we iterate over all strings in input array
First we append length, then a '/' and then the string
so, sb after "Hello" -> "5/Hello"
sb after "World"     -> "5/Hello5/World"

On Decoding,
We create an arratlist of string which is to be returned
We start from the beginning on input string "5/Hello5/World"
we find the index of slash starting from index i (which is currently 0)
slash = 1
Now we get size of substring to take which is taken from number before slash
size = 5
i = slash + size + 1 // end of string
i = 7
Add substring(slash+1, i) = Hello
and similarly we start while loop from new value of i
*/
