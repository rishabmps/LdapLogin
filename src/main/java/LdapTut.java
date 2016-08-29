


import java.util.Properties;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.NameParser;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LdapTut {

     public static void main(String[] args) {
          // TODO Auto-generated method stub
          
          Properties properties = new Properties();
          properties.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
          properties.put(Context.PROVIDER_URL, "ldap://ina2apacdc10.apac.sas.com:389/dc=apac,DC=sas,DC=com");
          properties.put(Context.SECURITY_PRINCIPAL, "row\\idnrsj");
          properties.put(Context.SECURITY_CREDENTIALS, "asdsad");
          properties.put(Context.SECURITY_AUTHENTICATION, "simple");
          try {
              DirContext context = new InitialDirContext(properties);
              System.out.println("Context Intiallized "); 
              DirContext users = (DirContext) context.lookup("OU=India");
              //DirContext rowUsers = (DirContext) users.lookup("CN=VIDNASRINA6");
              DirContext rowUsers = (DirContext) users.lookup("OU=PuneIDeaS");
              DirContext actualUsers = (DirContext) rowUsers.lookup("OU=Users");
              //DirContext ideasUsers = (DirContext) users.lookup("OU=IDeaS");
              
              NameParser nameParser = users.getNameParser("");
              NamingEnumeration<Binding> listBindings = actualUsers .listBindings("");
              while (listBindings.hasMoreElements()) {
                   Binding binding = (Binding) listBindings.nextElement();
                   //System.out.println(binding);
                   String name = binding.getName();
                   System.out.println(name);
                   Attributes attributes2 =actualUsers.getAttributes(name);
                   NamingEnumeration m = attributes2.getAll();
                   while(m.hasMore()){
                	   System.out.println(m.next());
                   }
                   break;
              }
              
          
              
          } catch (NamingException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } 
          
          //8088667777
          
     }

}

