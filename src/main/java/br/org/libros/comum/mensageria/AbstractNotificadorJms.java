package br.org.libros.comum.mensageria;

import java.lang.invoke.MethodHandles;

import javax.enterprise.event.Observes;
import javax.jms.JMSContext;
import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.org.libros.comum.model.persistence.entity.listener.EventoEntidade;
import br.org.libros.comum.model.persistence.entity.listener.IEntidadeAtualizada;
import br.org.libros.comum.model.persistence.entity.listener.IEntidadePersistida;
import br.org.libros.comum.model.persistence.entity.listener.IEntidadeRemovida;

/**
 * Classe abstrata responsável por enviar notificações de eventos através de JMS.
 * 
 */
public abstract class AbstractNotificadorJms {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	protected Queue fila;

	protected JMSContext contextoJms;

	protected void setContextoJms(JMSContext contextoJms) {
		this.contextoJms = contextoJms;
	}

	protected void setFila(Queue fila) {
		this.fila = fila;
	}

	/**
	 * Método executado quando a entidade é atualizada, persistida ou removida.
	 * 
	 * @param evento
	 *            o evento específico que resultou na execução desse método.
	 */
	@IEntidadeAtualizada
	@IEntidadePersistida
	@IEntidadeRemovida
	public void onEntidadeAtualizada(@Observes EventoEntidade evento) {
		enviarMensagemJms(evento.getPayload());
	}

	/**
	 * Envia mensagem JMS de notifição sobre a mudança na entidade.
	 * 
	 * @param payloadDoEvento
	 *            conteúdo do evento que será enviado na mensagem JMS.
	 */
	protected void enviarMensagemJms(String payloadDoEvento) {
		contextoJms.createProducer().send(fila, payloadDoEvento);
		logger.info("mensagem JMS enviada: " + payloadDoEvento);
	}
}
