/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.net.itsearch.gui;

import java.util.List;

import javax.swing.JOptionPane;

import crawler.SearchResultEntry;

/**
 *
 * @author 格格
 */
@SuppressWarnings("serial")
public class SearchMainPage extends javax.swing.JFrame {

    /**
     * Creates new form searchMainPage
     */
    public SearchMainPage() {
        initComponents();
        esGuiSearch=new EsGuiSearch();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */                       
    private void initComponents() {

        searchBox = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        picture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchButton.setText("搜索");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("jmu.png"))); 
        picture.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(256, 256, 256))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(picture)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        String queryString=searchBox.getText();
        List<SearchResultEntry> list = esGuiSearch.fullTextSerch(queryString);
        if(list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "未搜索到相关内容！");
        }else {
             SearchResult searchResult = new SearchResult(list); 
             searchResult.setVisible(true);
             dispose();
        }
       
    }                                            

    private EsGuiSearch esGuiSearch;             
    private javax.swing.JLabel picture;
    private javax.swing.JTextField searchBox;
    private javax.swing.JButton searchButton;
    // End of variables declaration                   
}
