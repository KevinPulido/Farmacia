package controllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.SystemView;

public class settingController implements MouseListener {

    private SystemView views;

    public settingController(SystemView views) {
        this.views = views;
        this.views.jLabelProductos.addMouseListener(this);
        this.views.jLabelCompras.addMouseListener(this);
        this.views.jLabelClientes.addMouseListener(this);
        this.views.jLabelEmpleados.addMouseListener(this);
        this.views.jLabelProveedores.addMouseListener(this);
        this.views.jLabelCategorias.addMouseListener(this);
        this.views.jLabelReportes.addMouseListener(this);
        this.views.jLabelConfiguracion.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == views.jLabelProductos) {
            views.JpanelProductos.setBackground(new Color(242, 242, 242));

        } else if (e.getSource() == views.jLabelCompras) {
            views.jPanelCompras.setBackground(new Color(242, 242, 242));

        } else if (e.getSource() == views.jLabelClientes) {
            views.jPanelClientes.setBackground(new Color(242, 242, 242));

        } else if (e.getSource() == views.jLabelEmpleados) {
            views.jPanelEmpleados.setBackground(new Color(242, 242, 242));

        } else if (e.getSource() == views.jLabelProveedores) {
            views.jPanelProveedores.setBackground(new Color(242, 242, 242));

        } else if (e.getSource() == views.jLabelCategorias) {
            views.jPanelCategorias.setBackground(new Color(242, 242, 242));

        } else if (e.getSource() == views.jLabelReportes) {
            views.jPanelReportes.setBackground(new Color(242, 242, 242));

        } else if (e.getSource() == views.jLabelConfiguracion) {
            views.jPanelConfiguracion.setBackground(new Color(242, 242, 242));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == views.jLabelProductos) {
            views.JpanelProductos.setBackground(new Color(255, 255, 255));

        } else if (e.getSource() == views.jLabelCompras) {
            views.jPanelCompras.setBackground(new Color(255, 255, 255));

        } else if (e.getSource() == views.jLabelClientes) {
            views.jPanelClientes.setBackground(new Color(255, 255, 255));

        } else if (e.getSource() == views.jLabelEmpleados) {
            views.jPanelEmpleados.setBackground(new Color(255, 255, 255));

        } else if (e.getSource() == views.jLabelProveedores) {
            views.jPanelProveedores.setBackground(new Color(255, 255, 255));

        } else if (e.getSource() == views.jLabelCategorias) {
            views.jPanelCategorias.setBackground(new Color(255, 255, 255));

        } else if (e.getSource() == views.jLabelReportes) {
            views.jPanelReportes.setBackground(new Color(255, 255, 255));

        } else if (e.getSource() == views.jLabelConfiguracion) {
            views.jPanelConfiguracion.setBackground(new Color(255, 255, 255));
        }
    }

}
