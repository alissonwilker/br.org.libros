package br.org.libros.livro.mensageria;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import br.org.libros.comum.mensageria.AbstractNotificadorJms;

/**
 * 
 * @see br.org.libros.comum.mensageria.AbstractNotificadorJms
 */
@Stateless
public class LivroNotificadorJms extends AbstractNotificadorJms {
	@Resource(mappedName = "java:/jms/queue/ExpiryQueue")
	private Queue fila;

	@Inject
	@JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
	private JMSContext contextoJms;

	@PostConstruct
	public void init() {
		setFila(fila);
		setContextoJms(contextoJms);
	}

}
