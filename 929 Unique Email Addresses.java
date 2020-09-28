// https://leetcode.com/problems/unique-email-addresses/


class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        
        for (int i = 0; i < emails.length; i++) {
            String canonical = toCanonical(emails[i]);
            uniqueEmails.add(canonical);
        }
        
        return uniqueEmails.size();
    }
    
    private String toCanonical(String email) {
        char[] canonical = new char[email.length()];
        int write_pos = 0;
        int read_pos = 0;
        char c = 0;
        
        while ((c = email.charAt(read_pos)) != '@') {
            if (c == '.') { 
                // Skip this char 
            } else if (c == '+') { 
                break; 
            } else {
                canonical[write_pos++] = c;            
            }
            read_pos++;
        }
        
        while ((c = email.charAt(read_pos)) != '@') {
            read_pos++;
        }
        
        while (read_pos < email.length()) {
            c = email.charAt(read_pos);
            canonical[write_pos++] = c;
            read_pos++;
        }
        
        return new String(canonical, 0, write_pos);
    }
}


// class Solution {
//   public int numUniqueEmails(String[] emails) {
//     Set<String> seen = new HashSet();
//     for (String email : emails) {
//       int i = email.indexOf('@');
//       String local = email.substring(0, i);
//       String rest = email.substring(i);
//       if (local.contains("+")) {
//         local = local.substring(0, local.indexOf('+'));
//       }
//       // Note: one should escape the specific character '.',
//       // since it is treated as a regex expression.
//       local = local.replaceAll("\\.", "");
//       seen.add(local + rest);
//     }

//     return seen.size();
//   }
// }
