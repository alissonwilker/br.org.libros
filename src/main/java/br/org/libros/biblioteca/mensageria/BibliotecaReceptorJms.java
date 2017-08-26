package br.org.libros.biblioteca.mensageria;

import java.lang.invoke.MethodHandles;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.org.libros.comum.mensageria.AbstractReceptorJms;

/**
 * 
 * @see br.org.libros.comum.mensageria.AbstractReceptorJms
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/ExpiryQueue") })
public class BibliotecaReceptorJms extends AbstractReceptorJms {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	public void onMessage(Message mensagem) {
		try {
			logger.info("mensagem JMS recebida pelo módulo Biblioteca: " + mensagem.getBody(String.class));
		} catch (JMSException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
