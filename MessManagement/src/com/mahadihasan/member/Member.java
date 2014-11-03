
package com.mahadihasan.member;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class Member {
    
    private String firstName;
    private String lastName;
    private String nickName;
    private String mobileNo;
    private String email;
    
    
    public Member(String fName, String lName,
            String nName, String mob, String mail) {
        
        setFirstName(fName);
        setLastName(lName);
        setNickName(nName);
        setMobileNo(mob);
        setEmail(mail);
        
    }
    
    private void setFirstName(String fName) {
        firstName = fName;
    }
    private void setLastName(String lName) {
        lastName = lName;
    }
    private void setNickName(String nName) {
        nickName = nName;
    }
    private void setMobileNo(String mob) {
        mobileNo = mob;
    }
    private void setEmail(String mail) {
        email = mail;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getNickName() {
        return nickName;
    }
    
    public String getMobileNo() {
        return mobileNo;
    }
    
    public String getEmail() {
        return email;
    }
}
