package operatingSystem.fileSystem;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import operatingSystem.Kernel;

public class FileSytemSimulator extends javax.swing.JFrame {

    Kernel myKernel = null;
    
    /** Creates new form SSH */
    public FileSytemSimulator(Kernel myKernel) {
        initComponents();
        //verificando validade da classe de kernel
        if( myKernel == null){
            System.err.println("Kernel corrompido.");
            System.exit(1);
        }
        else{
            this.myKernel = myKernel;
            this.base = "aluno@localhost:";
            this.escreverDiretorio();
        }

    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCommand = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File System Simulator");
        setBackground(new java.awt.Color(1, 1, 1));

        txtCommand.setBackground(new java.awt.Color(0, 0, 0));
        txtCommand.setFont(new java.awt.Font("Courier New", 0, 14));
        txtCommand.setForeground(new java.awt.Color(255, 255, 255));
        txtCommand.setText("aluno@localhost:~$");
        txtCommand.setCaretColor(new java.awt.Color(255, 255, 255));
        txtCommand.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCommand.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtCommand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                try {
					txtCommandKeyPressed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCommandKeyReleased(evt);
            }
        });

        textArea.setBackground(new java.awt.Color(0, 0, 0));
        textArea.setColumns(20);
        textArea.setEditable(false);
        textArea.setFont(new java.awt.Font("Courier New", 0, 14));
        textArea.setForeground(new java.awt.Color(255, 255, 255));
        textArea.setRows(5);
        textArea.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(textArea);

        jScrollPane3.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCommand, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCommand, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCommandKeyPressed(java.awt.event.KeyEvent evt) throws FileNotFoundException, IOException {//GEN-FIRST:event_txtCommandKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String command = this.txtCommand.getText();
            this.adicionarAreaDeTexto(this.txtCommand.getText());
            
            //eliminando ">" do inicio do comando...
            command = command.substring((this.base.length()+FileSytemSimulator.currentDir.length()+2), command.length());
            dispararComando( command );
            
            this.escreverAreaDeTexto();
            this.escreverDiretorio();
        }
        
}//GEN-LAST:event_txtCommandKeyPressed

    private void txtCommandKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCommandKeyReleased
        if( this.txtCommand.getText().length() <= (this.base.length()+FileSytemSimulator.currentDir.length()+2) || this.txtCommand.getText().length() == 0 ){
            this.escreverDiretorio();
        }
    }//GEN-LAST:event_txtCommandKeyReleased
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileSytemSimulator(null).setVisible(true);
            }
        });
    }
  
    private String lastCommand = "";
    private String lastResult = "";
    private String base = "";
    public static String currentDir = "/";
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField txtCommand;
    // End of variables declaration//GEN-END:variables

    private void dispararComando( String comando ) throws FileNotFoundException, IOException{
        //se algum comando for dado
        if( !comando.trim().equals("") ){
            String args[] = comando.split(" ");
            
            //se comando for "cd"
            if( args[0].equals("cd") ){
                if( args.length != 1)
                    this.lastResult = this.myKernel.cd(comando.trim().substring(3, comando.trim().length()));
                else
                    this.lastResult = this.myKernel.cd("");
            }
            //se comando for "ls"
            else if( args[0].equals("ls") ){
                if( args.length != 1)
                    this.lastResult = this.myKernel.ls(comando.trim().substring(3, comando.trim().length()));
                else
                    this.lastResult = this.myKernel.ls("");
            }
            //se comando for "mkdir"
            else if( args[0].equals("mkdir") ){
                if( args.length != 1)
                    this.lastResult = this.myKernel.mkdir(comando.trim().substring(6, comando.trim().length()));
                else
                    this.lastResult = this.myKernel.mkdir("");
            }
            //se comando for "rmdir"
            else if( args[0].equals("rmdir") ){
                if( args.length != 1)
                    this.lastResult = this.myKernel.rmdir(comando.trim().substring(6, comando.trim().length()));
                else
                    this.lastResult = this.myKernel.rmdir("");
            }    
            //se comando for "cp"
            else if( args[0].equals("cp") ){
                if( args.length != 1)
                    this.lastResult = this.myKernel.cp(comando.trim().substring(3, comando.trim().length()));
                else
                    this.lastResult = this.myKernel.cp("");
            }             
            //se comando for "mv"
            else if( args[0].equals("mv") ){
                if( args.length != 1)
                    this.lastResult = this.myKernel.mv(comando.trim().substring(3, comando.trim().length()));
                else
                    this.lastResult = this.myKernel.mv("");
            }             
            //se comando for "rm"
            else if( args[0].equals("rm") ){
                if( args.length != 1)
                    this.lastResult = this.myKernel.rm(comando.trim().substring(3, comando.trim().length()));
                else
                    this.lastResult = this.myKernel.rm("");
            }   
            //se comando for "chmod"
            else if( args[0].equals("chmod") ){
                if( args.length != 1)
                    this.lastResult = this.myKernel.chmod(comando.trim().substring(6, comando.trim().length()));
                else
                    this.lastResult = this.myKernel.chmod("");
            }          
            //se comando for "createfile"
            else if( args[0].equals("createfile") ){
                if( args.length != 1)
                    this.lastResult = this.myKernel.createfile(comando.trim().substring(11, comando.trim().length()));
                else
                    this.lastResult = this.myKernel.createfile("");
            }    
            //se comando for "cat"
            else if( args[0].equals("cat") ){
                if( args.length != 1)
                    this.lastResult = this.myKernel.cat(comando.trim().substring(4, comando.trim().length()));
                else
                    this.lastResult = this.myKernel.cat("");
            }              
            //se comando for "batch"
            else if( args[0].equals("batch") ){
                if( args.length != 1)
                    this.lastResult = this.myKernel.batch(comando.trim().substring(6, comando.trim().length()));
                else
                    this.lastResult = this.myKernel.batch("");
            }
            //se comando for "dump"
            else if( args[0].equals("dump") ){
                if( args.length != 1)
                    this.lastResult = this.myKernel.dump(comando.trim().substring(5, comando.trim().length()));
                else
                    this.lastResult = this.myKernel.dump("");
            }
            else if( args[0].equals("info") ){
                this.lastResult = this.myKernel.info();
            }   
            //se o comando não é reconhecido
            else{
                this.lastResult = comando + ": Comando invalido.";
            }
        }
    }

    private void escreverDiretorio(){
        this.txtCommand.setText(this.base+FileSytemSimulator.currentDir+"$ ");
    }
    
    private void escreverAreaDeTexto(){
        if( this.lastResult.equals("") )
            this.textArea.append(this.lastCommand);
        else
            this.textArea.append(this.lastCommand + "\n" + this.lastResult);
        
        this.lastCommand = "";
        this.lastResult = "";
    }
    
    private void adicionarAreaDeTexto(String str){
        this.lastCommand+="\n"+str;
    }
    
}
