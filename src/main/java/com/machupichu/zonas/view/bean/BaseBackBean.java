package com.machupichu.zonas.view.bean;

import com.machupichu.zonas.utils.BusinessException;
import com.machupichu.zonas.view.utils.Fechas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Map;

public abstract class BaseBackBean implements Serializable {

    Logger logger = LoggerFactory.getLogger(BaseBackBean.class);

    /**
     * Mostrar mensaje informativo al cliente
     * @param summary Cabecera del mensaje
     * @param detail Detalle del mensaje
     */
    protected void showInfoMessage(String summary, String detail){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("message", new FacesMessage(FacesMessage.SEVERITY_INFO, summary,detail));
    }

    protected void showWARNINGMessage(String titulo, String detail){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("message", new FacesMessage(FacesMessage.SEVERITY_WARN, titulo,detail));
    }

    /**
     * Mostrar mensaje de error al cliente
     * @param summary Cabecera del mensaje
     * @param detail Detalle del mensaje
     */
    protected void showErrorMessage(String summary, String detail) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("messageError", new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail)  );
    }

    protected void showErrorFATALMessage(String summary, String detail) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("messageError", new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail) );
    }

    protected void showErrorMessage(String className, String message,Exception e) {
        //Registramos en el log del servidor, solo los errores que no sean de negocio
        if(!(e instanceof BusinessException)){
            logger.error(className + ": "+ e.getMessage(),e);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("messageError", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, e.getMessage()));
    }

    protected void showErrorMessage(String message,Exception e) {
        //Registramos en el log del servidor, solo los errores que no sean de negocio
        if(!(e instanceof BusinessException)){
            logger.error(e.getMessage(),e);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("messageError", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, e.getMessage()));
    }

    protected void printReport(Map<String, String> params){
        if(params == null) return;

        for(Map.Entry<String, String> obj : params.entrySet()){
            FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts().add("rptParam('"+ obj.getKey() + "', '" + obj.getValue() + "');");
        }

        FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts().add("rptSubmit();");
    }

    public String formatearSeparadorMilesYDecimales(BigDecimal bigDecimal){
        return bigDecimal!=null ? NumberFormat.getNumberInstance().format(bigDecimal) : null;
    }

    public void notImplemented(String header, String summary) {
        showInfoMessage(header, summary);
    }

    public LocalDate obtenerFechaActual() {
        return Fechas.getFechaActual();
    }

    public LocalDate obtenerFechaActualMasDias(int days) {
        return Fechas.getFechaActual().plusDays(days);
    }

    public LocalDate obtenerFechaActualMenosDias(int days) {
        return Fechas.getFechaActual().minusDays( days );
    }


    public static double truncateValor(Object value) {
        if ( value == null )
            return 0d;
        else {
            Double valor = Double.parseDouble(value.toString() );
            return truncateValor( valor.doubleValue() );
        }
    }

    public static double truncateValor(BigDecimal valor) {
        if (valor == null )
            return 0d;
        return truncateValor( valor.doubleValue() );
    }


    public static double truncateValor(Double valor) {
        try {
            if ( valor == null )
                return 0;

            DecimalFormat df2 = new DecimalFormat("#####0.000");
            String cadena = new Double(df2.format(valor)).toString();
            int puntoPosicion = cadena.indexOf(".");
            String resto = cadena.substring(puntoPosicion);

            cadena = cadena.concat("00");
            String newCadena = cadena.substring(0, puntoPosicion + 3);
            return Double.valueOf(newCadena);
        } catch (Exception e) {
            System.out.println("Truncate: valor del objeto pasado" + valor);
            e.printStackTrace();
            return 0d;
        }
    }


}
