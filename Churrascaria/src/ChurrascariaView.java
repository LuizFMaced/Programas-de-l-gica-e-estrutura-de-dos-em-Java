import javax.swing.*; // pacote de elementos gráficos 
import java.awt.*; // pacote do Container
import java.awt.event.*;//pacote de ação em botoes
import java.text.DecimalFormat;//pacote de casas decimais
import java.io.*; //gravação em disco(arquivos)

//JFrame - classe responsável pela construção de janelas
//extends - Cláusula que representa a herança entre classes
public class ChurrascariaView extends JFrame implements ActionListener{
 
    public static FileWriter arquivo;
    public static PrintWriter gravar;
    
    public static DecimalFormat fmtMoeda = new DecimalFormat("0.00");
    
    //construindo objetoVO para acesso a dados da outra classe
    public static ChurrascariaVO dados = new ChurrascariaVO();
    
    /******* DECLARAÇÃO DOS OBJETOS DA TELA ********/
    
    //O COntainer é um objeto que vai vinculado à janela
    //para receber os elementos da tela
    public static Container ctnTela;

    public static ImageIcon imgBanner;//Classe de Imagens
    public static JLabel lblBanner;//JLabel - Rotulo fixo na tela: recebe texto ou imagem
    
    public static JLabel lblRodizio, lblPessoas, lblSubTotal,
                         lblAdicionais, lblServicos, lblEstacionamento,
                         lblTotal;
    
    //JTextField - Caixas de Texto
    public static JTextField txtRodizio, txtPessoas, txtSubTotal,
                             txtAdicionais, txtServicos, txtTotal;    
    
    //ButtonGroup é uma classe que define a categoria
    //dos botões de opção permitindo que apenas um deles
    //seja selecionado.
    //JRadioButton é a classe de construção para cada
    //botão de opção
    public static ButtonGroup btgEstacionamento;
    public static JRadioButton rdbSim, rdbNao;
    
    //JButton - Botões
    public static JButton btnAtualizar, btnFecharConta, btnGerarNota;
    
    public static JButton btnBebidas[];
    public static JButton btnSobremesas[];
    
    public ChurrascariaView(){ //método construtor
         
        super("Rodízio de Carnes RATOS FRITOS - Sistema de Gerenciamento");
        
        /* CONSTRUÇÃO DOS OBJETOS DE TELA */
        ctnTela = new Container(); //Construindo Container
        ctnTela.setLayout(null); //layout para livre posicionamento dos objetos
        this.add(ctnTela); //adicionando Container na janela
        
        imgBanner = new ImageIcon("img/banner.jpg");//Construindo imagem do banner
        lblBanner = new JLabel(imgBanner);//construindo label com a imagem
        lblBanner.setBounds(0,0,1024,210);//definindo posicionamento da label
            //setBounds(x,y,w,h);
            //x = distancia da lateral esquerda
            //y = distancia do topo
            //w = largura;
            //h = altura;
         ctnTela.add(lblBanner);
         
         lblRodizio = new JLabel("Valor por pessoa:");
         lblRodizio.setForeground(Color.black);//cor da fonte
         lblRodizio.setFont(new Font("Tahoma",Font.BOLD,20));//estilo da fonte
         lblRodizio.setBounds(20,230,180,30);
         ctnTela.add(lblRodizio);
         
         lblPessoas = new JLabel("Número de Pessoas:");
         lblPessoas.setForeground(Color.black);//cor da fonte
         lblPessoas.setFont(new Font("Tahoma",Font.BOLD,20));//estilo da fonte
         lblPessoas.setBounds(20,275,210,30);
         ctnTela.add(lblPessoas);
         
         lblSubTotal = new JLabel("Sub-Total:");
         lblSubTotal.setForeground(Color.blue);//cor da fonte
         lblSubTotal.setFont(new Font("Tahoma",Font.BOLD,22));//estilo da fonte
         lblSubTotal.setBounds(20,320,150,30);
         ctnTela.add(lblSubTotal);
         
         lblAdicionais = new JLabel("Adicionais:");
         lblAdicionais.setForeground(Color.black);//cor da fonte
         lblAdicionais.setFont(new Font("Tahoma",Font.BOLD,20));//estilo da fonte
         lblAdicionais.setBounds(20,365,180,30);
         ctnTela.add(lblAdicionais);
         
         lblServicos = new JLabel("Serviços:");
         lblServicos.setForeground(Color.black);//cor da fonte
         lblServicos.setFont(new Font("Tahoma",Font.BOLD,20));//estilo da fonte
         lblServicos.setBounds(20,410,180,30);
         ctnTela.add(lblServicos);
         
         lblEstacionamento = new JLabel("Estacionamento:");
         lblEstacionamento.setForeground(Color.black);//cor da fonte
         lblEstacionamento.setFont(new Font("Tahoma",Font.BOLD,20));//estilo da fonte
         lblEstacionamento.setBounds(20,455,180,30);
         ctnTela.add(lblEstacionamento);
         
         lblTotal = new JLabel("Total a pagar:");
         lblTotal.setForeground(Color.red);//cor da fonte
         lblTotal.setFont(new Font("Tahoma",Font.BOLD,26));//estilo da fonte
         lblTotal.setBounds(20,565,200,30);
         ctnTela.add(lblTotal);
                           
         txtRodizio = new JTextField();
         txtRodizio.setEditable(false);//desabilitando caixa de texto
         txtRodizio.setFont(new Font("Verdana", Font.PLAIN,24));
         txtRodizio.setBackground(Color.lightGray);
         txtRodizio.setBounds(220,230,200,30);
         ctnTela.add(txtRodizio);
         
         txtPessoas = new JTextField();
         txtPessoas.setEditable(true);//desabilitando caixa de texto
         txtPessoas.setFont(new Font("Verdana", Font.PLAIN,24));
         txtPessoas.setBackground(Color.lightGray);
         txtPessoas.setBounds(240,275,40,30);
         ctnTela.add(txtPessoas);
         
         txtSubTotal = new JTextField();
         txtSubTotal.setEditable(false);//desabilitando caixa de texto
         txtSubTotal.setFont(new Font("Verdana", Font.PLAIN,24));
         txtSubTotal.setBackground(Color.lightGray);
         txtSubTotal.setBounds(220,320,200,30);
         ctnTela.add(txtSubTotal);
         
         txtAdicionais = new JTextField();
         txtAdicionais.setEditable(false);//desabilitando caixa de texto
         txtAdicionais.setFont(new Font("Verdana", Font.PLAIN,24));
         txtAdicionais.setBackground(Color.lightGray);
         txtAdicionais.setBounds(220,365,200,30);
         ctnTela.add(txtAdicionais);
         
         txtServicos = new JTextField();
         txtServicos.setEditable(false);//desabilitando caixa de texto
         txtServicos.setFont(new Font("Verdana", Font.PLAIN,24));
         txtServicos.setBackground(Color.lightGray);
         txtServicos.setBounds(220,410,200,30);
         ctnTela.add(txtServicos);
         
         txtTotal = new JTextField();
         txtTotal.setEditable(false);//desabilitando caixa de texto
         txtTotal.setFont(new Font("Verdana", Font.PLAIN,24));
         txtTotal.setBackground(Color.lightGray);
         txtTotal.setBounds(220,565,200,30);
         ctnTela.add(txtTotal);
           
         btgEstacionamento = new ButtonGroup();
         rdbSim = new JRadioButton("Sim");
         rdbNao = new JRadioButton("Não");
         rdbNao.setSelected(true);
         //Adicionando RadioButtons ao grupo
         btgEstacionamento.add(rdbSim);
         btgEstacionamento.add(rdbNao);
         
         rdbSim.setFont(new Font("Tahoma",Font.BOLD,20));
         rdbNao.setFont(new Font("Tahoma",Font.BOLD,20));
         
         //Posicionando e adicionando botoes de opção
         rdbSim.setBounds(220,455,70,30);
         rdbNao.setBounds(300,455,70,30);
         ctnTela.add(rdbSim);
         ctnTela.add(rdbNao);
         
         btnAtualizar = new JButton("Atualizar", new ImageIcon("img/icnAtualizar.png"));
         btnAtualizar.addActionListener(this);
         btnAtualizar.setBounds(290,275,130,30);
         ctnTela.add(btnAtualizar);
         
         btnFecharConta = new JButton("Fechar Conta");
         btnFecharConta.addActionListener(this);
         btnFecharConta.setFont(new Font("Tahoma",Font.BOLD,24));
         btnFecharConta.setBounds(20,500,400,45);
         ctnTela.add(btnFecharConta);
         
         btnGerarNota = new JButton("CPF na Nota");
         btnGerarNota.addActionListener(this);
         btnGerarNota.setFont(new Font("Tahoma",Font.BOLD,24));
         btnGerarNota.setBounds(20,620,400,75);
         ctnTela.add(btnGerarNota);
         
         //construção dos vetores de botões - bebidas
         btnBebidas = new JButton[dados.bebidas.length];
         int auxB = 0;
         for(int i=0; i<btnBebidas.length; i++){
             btnBebidas[i] = new JButton(new ImageIcon("img/b" + i + ".jpg"));
             btnBebidas[i].addActionListener(this);
             ctnTela.add(btnBebidas[i]);
             
             if(i<btnBebidas.length/2){
                 btnBebidas[i].setBounds(500+(i*115),255,100,100);
             }else{
                 
                 btnBebidas[i].setBounds(500+(auxB*115),370,100,100);
                 auxB++;
             }             
         }
         
        //construção dos vetores de botões - sobremesas        
         btnSobremesas = new JButton[dados.sobremesas.length];
         int auxS=0;
         for(int i=0; i<btnSobremesas.length;i++){
             btnSobremesas[i] = new JButton(new ImageIcon("img/s" + i + ".jpg"));
             btnSobremesas[i].addActionListener(this);
             ctnTela.add(btnSobremesas[i]);
             
             if(i<btnSobremesas.length/2){
                 btnSobremesas[i].setBounds(500+(i*115),490,100,100);
             }else{
                 btnSobremesas[i].setBounds(500+(auxS*115),610,100,100);
                 auxS++;
             }
         }
                  
         atualizarCampos(); //chamando método
         
         //O comando abaixo encerra o processo ao fechar a janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //alterando fundo da janela
        this.getContentPane().setBackground(Color.white);
        
        this.setResizable(false);//desabilita dimensionamento da tela
        this.setSize(1024,768);//dimensões da janela
        this.setVisible(true);//exibindo janela
        
    }//fechando construtor
    
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == btnAtualizar){
          dados.qtdePessoas = Integer.parseInt(
                              txtPessoas.getText());
          atualizarCampos();
          dados.NF+="Pessoas: " + dados.qtdePessoas + "\r\n"; 
          dados.NF+="Sub-Total: R$ " + fmtMoeda.format(dados.calcularSubTotal()) + "\r\n\r\n"; 
          
        }//fechando btnAtualizar 
        
        for(int i=0; i<btnBebidas.length;i++){
            if(evt.getSource() == btnBebidas[i]){
                dados.valorAdicionais+=dados.vBebidas[i];
                dados.NF+=dados.bebidas[i] + ": R$ " + fmtMoeda.format(dados.vBebidas[i]) + "\r\n";
                atualizarCampos();
            }
        }//fechando for btnBebidas
        
        for(int i=0; i<btnSobremesas.length;i++){
            if(evt.getSource() == btnSobremesas[i]){
                dados.valorAdicionais+=dados.vSobremesas[i];
                dados.NF+=dados.sobremesas[i] + ": R$ " + fmtMoeda.format(dados.vSobremesas[i]) + "\r\n";
                atualizarCampos();
            }
        }//fechando for btnSobremesas
        
        if(evt.getSource()==btnFecharConta){
            
            float tmpEstacionamento;                
            if(rdbSim.isSelected()){
                tmpEstacionamento = dados.valorEstacionamento;
            }else{
                tmpEstacionamento = 0;
            }
        
        txtTotal.setText("RS " + fmtMoeda.format(dados.calcularTotal(tmpEstacionamento)));
                    
        dados.NF+="\r\nTotal de Adicionais: R$ " + fmtMoeda.format(dados.valorAdicionais) + "\r\n";
        dados.NF+="Serviços: R$ " + fmtMoeda.format(dados.calcularServicos()) + "\r\n";
        dados.NF+="Estacionamento: R$ " + fmtMoeda.format(tmpEstacionamento) + "\r\n";
        dados.NF+="Total a pagar: R$ " + fmtMoeda.format(dados.calcularTotal(tmpEstacionamento)) + "\r\n";
               
        //JOptionPane.showMessageDialog(null,dados.NF);
        
        }//fechando if btnFecharConta      
        
        if(evt.getSource()==btnGerarNota){
            
            int resp = JOptionPane.showConfirmDialog(null,
                "CPF na nota?", "NF",JOptionPane.YES_NO_OPTION);
            
            if(resp == JOptionPane.YES_OPTION){
             //gravaçao do arquivo em disco   
             String cpf = JOptionPane.showInputDialog(
                            "Entre com o CPF:");
             dados.NF+="\r\nCLIENTE: " + cpf;
             try{
                 arquivo = new FileWriter("docs/NF_" + cpf + ".txt");
                 gravar = new PrintWriter(arquivo);
                 
                 gravar.write(dados.NF);
                 arquivo.close();                 
                 
             }catch(Exception erro){
                 JOptionPane.showMessageDialog(null, 
                         "Falha na gravação.");
             }//fechando try...catch
             
            }
             
            JOptionPane.showMessageDialog(null, "VOLTE SEMPRE");
            dados.zerarDados();
            atualizarCampos();
            txtTotal.setText("RS " + fmtMoeda.format(dados.calcularTotal(0)));
            
        }
        
    }//fechando actionPerformed
    
    public static void atualizarCampos(){
    
        txtRodizio.setText("R$ " + fmtMoeda.format(dados.valorRodizio));
        txtPessoas.setText("" + dados.qtdePessoas);
        txtSubTotal.setText("R$ " + fmtMoeda.format(dados.calcularSubTotal()));
        txtAdicionais.setText("RS " + fmtMoeda.format(dados.valorAdicionais));
        txtServicos.setText("RS " + fmtMoeda.format(dados.calcularServicos()));
        
        
    }//fechando atualizaCampos
    
}//fechando classe



