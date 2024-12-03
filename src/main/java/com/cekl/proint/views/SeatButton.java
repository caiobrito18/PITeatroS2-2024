/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cekl.proint.views;

import com.cekl.proint.models.Selection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author caio
 */
public class SeatButton extends JButton {
    JFrame parentFrame;
    public SeatButton(String name, String seatNumber, Boolean ocupied, Selection pSel, JFrame parent){
    super("Assento"+ name);
    this.parentFrame = parent;
    this.setText(seatNumber);
    Color background = !ocupied ? Color.GREEN : Color.RED;
    this.setBackground(background);
    super.addActionListener((java.awt.event.ActionEvent evt) -> {
        pSel.setPoltrona(Integer.parseInt(seatNumber));
        System.out.println(Integer.toString(pSel.getPoltrona()));
        parentFrame.dispose();
    });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width += size.height;
        return size;
    }

    

    
    
}
