/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico3;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Matheus
 */
public class ModeloTabela extends AbstractTableModel{
   
    ArrayList<Investimentos> investimento;
    
    public ModeloTabela(){
        investimento=new ArrayList<>();
    }
    
    @Override
    //Retorna o número de linhas
    public int getRowCount() {
        return investimento.size();
    }

    @Override
    //Retorna o número de colunas
    public int getColumnCount() {
        return 6;
    }

    @Override
    //Retorna o que está numa célula
    public Object getValueAt(int linha, int coluna) {
        if(coluna==0){
            return investimento.get(linha).getNome();
        }
        else if(coluna==1){
            return investimento.get(linha).getValorAporte();
        }
        else if(coluna==2){
            return investimento.get(linha).getData();
        }
        else if(coluna==3){
            return investimento.get(linha).getValorAtual();
        }
        else if(coluna==4){
            return investimento.get(linha).getLucro();
        }
        else{
            return investimento.get(linha).getRetorno();
        }

    }

    @Override
    //Permite que as células da coluna de Valor Atual sejam modificadas
    public boolean isCellEditable(int linha, int coluna) {
        if(coluna == 3){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void setValueAt(Object novoValor, int linha, int coluna) {
        //Altera o Valor Atual
        double valorAtual = ((double) novoValor);
        this.investimento.get(linha).setValorAtual((double) novoValor);
        
        //Modifica o lucro e o retorno
        double valorAporte= this.investimento.get(linha).getValorAporte();
        
        double lucro= valorAtual - valorAporte;
        double retorno=((valorAtual*100)/valorAporte)-100;
        //Arrendonda o valor do retorno
        DecimalFormat df = new DecimalFormat("#.00");
        String retornoStr = (df.format(retorno)).replaceAll(",", ".");
        retorno=Double.parseDouble(retornoStr);
        
        this.investimento.get(linha).setLucro(lucro);
        this.investimento.get(linha).setRetorno(retorno);
        
        //Fala para o programa atualizar os valores das células
        fireTableRowsUpdated(linha, linha);
    }

    @Override
    public Class<?> getColumnClass(int coluna) {
        if(coluna==0 || coluna==2){
            return String.class;
        }else{
            return Double.class;
        }    
    }

    public void addInvestimento(Investimentos invest) {
        investimento.add(invest);
    }

    @Override
    //Altera o nome das colunas
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0: return "Nome";
            case 1: return "V. Aporte";
            case 2: return "Data";
            case 3: return "V. Atual";
            case 4: return "Lucro";
            case 5: return "Retorno (%)";
            default: return "";
        }
    }

    

}
