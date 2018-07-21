
package MainHome;
/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class splashscreen {
    public static void main(String args[]){
         
        launcher launch=new launcher();
        launch.setVisible(true);
       
        try{
            for(int i=0;i<=100;i++)
            {
                Thread.sleep(80);
                launch.progper.setText("Loading...  "+Integer.toString(i)+"%");
                launch.progbar.setValue(i);
                if(i==100){
                 launch.dispose();
                 new LoginForm().setVisible(true);
                 
                   
                }
            }            
        }
        catch(InterruptedException e){
            
        }
        
        
    }
}
