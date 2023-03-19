package com.conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InterfazConversor extends JFrame {

	private JPanel contentPane;

	private Conversor conversor;
    private JComboBox<String> cmbUnidadOrigen;
    private JComboBox<String> cmbUnidadDestino;
    private JTextField txtCantidad;
    private JTextField txtResultado;
    private JLabel lblCantidad;
    private JLabel lblUnidadOrigen;
    private JLabel lblUnidadDestino;
    private JLabel lblResultado;
    private JButton btnConvertir;
    private JMenu menuUnidades;
    private JMenuBar menuBar;

    public InterfazConversor() {
        conversor = new Conversor();
        txtCantidad = new JTextField(10);
        txtResultado = new JTextField(10);
        lblCantidad = new JLabel("Cantidad:");
        lblUnidadOrigen = new JLabel("Unidad origen:");
        lblUnidadDestino = new JLabel("Unidad destino:");
        lblResultado = new JLabel("Resultado:");
        btnConvertir = new JButton("Convertir");
        menuBar = new JMenuBar();

        // Crear el menú de unidades
        menuUnidades = new JMenu("Unidades");

        // Crear los elementos del menú para las unidades de medida
        JMenuItem itemLongitud = new JMenuItem("Longitud");
        JMenuItem itemTemperatura = new JMenuItem("Temperatura");
        JMenuItem itemMoneda = new JMenuItem("Moneda");

        // Agregar los elementos del menú al menú de unidades
        menuUnidades.add(itemLongitud);
        menuUnidades.add(itemTemperatura);
        menuUnidades.add(itemMoneda);

        // Agregar el menú de unidades a la barra de menú
        menuBar.add(menuUnidades);
        setJMenuBar(menuBar);

        // Asignar el controlador de eventos para el botón de conversión
        btnConvertir.addActionListener(e -> {
            String unidadOrigen = (String) cmbUnidadOrigen.getSelectedItem();
            String unidadDestino = (String) cmbUnidadDestino.getSelectedItem();
            double cantidad = Double.parseDouble(txtCantidad.getText());
            double resultado = conversor.convertir(unidadOrigen, unidadDestino, cantidad);
            txtResultado.setText(String.format("%.2f", resultado));
        });

        // Asignar el controlador de eventos para el elemento del menú "Longitud"
        itemLongitud.addActionListener(e -> {
            String[] unidadesLongitud = {"Metro", "Pulgada", "Pie", "Centímetro", "Kilómetro", "Milímetro"};
            cmbUnidadOrigen.setModel(new DefaultComboBoxModel<String>(unidadesLongitud));
            cmbUnidadDestino.setModel(new DefaultComboBoxModel<String>(unidadesLongitud));
        });

        // Asignar el controlador de eventos para el elemento del menú "Temperatura"
        itemTemperatura.addActionListener(e -> {
            String[] unidadesTemperatura = {"Celsius", "Fahrenheit", "Kelvin"};
            cmbUnidadOrigen.setModel(new DefaultComboBoxModel<String>(unidadesTemperatura));
            cmbUnidadDestino.setModel(new DefaultComboBoxModel<String>(unidadesTemperatura));
        });

        // Asignar el controlador de eventos para el elemento del menú "Moneda
        itemMoneda.addActionListener(e -> {
            String[] unidadesMoneda = {"Dólar", "Euro", "Libra E", "Yen", "Won CS", "Nuevo Sol"};
            cmbUnidadOrigen.setModel(new DefaultComboBoxModel<String>(unidadesMoneda));
            cmbUnidadDestino.setModel(new DefaultComboBoxModel<String>(unidadesMoneda));
        });

        // Configurar el diseño de la interfaz gráfica
        getContentPane().setLayout(new GridLayout(5, 2));
        getContentPane().add(lblCantidad);
        getContentPane().add(txtCantidad);
        getContentPane().add(lblUnidadOrigen);
        
                // Crear los componentes de la interfaz gráfica
                cmbUnidadOrigen = new JComboBox<String>();
                getContentPane().add(cmbUnidadOrigen);
        getContentPane().add(lblUnidadDestino);
                cmbUnidadDestino = new JComboBox<String>();
                getContentPane().add(cmbUnidadDestino);
        getContentPane().add(lblResultado);
        getContentPane().add(txtResultado);
        getContentPane().add(btnConvertir);
        // Configurar las propiedades de la ventana
        setTitle("Conversor de unidades");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazConversor frame = new InterfazConversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		new InterfazConversor();
	}


}