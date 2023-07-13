package br.com.alura.conversor.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.alura.conversor.model.CurrencyConverter;
import br.com.alura.conversor.service.exception.CurrencyConverterException;

/**
 * Client HTTP, criado via <b>Apache HttpClient</b>, para o consumo da API do
 * <b>AwesomeAPI</b>.
 * 
 * @see <a href="https://docs.awesomeapi.com.br/api-de-moedas">AwesomeAPI</a>
 * 
 * @author edielson-assis
 */
public class AwesomeAPIService {

	/** 
	 * Faz a chamada HTTP, via método Get, para API de moedas.
	 * 
	 * @param rate
	 * @return CurrencyConverter
	 */
	public static final CurrencyConverter getCurrencyConverter(String rate) {

		CurrencyConverter currencyConverter = null;

		HttpGet request = new HttpGet("https://economia.awesomeapi.com.br/last/" + rate);

		try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
			CloseableHttpResponse response = httpClient.execute(request)) {

			HttpEntity entity =	response.getEntity();			
			String result = EntityUtils.toString(entity);

			ObjectMapper objectMapper = new ObjectMapper();

			currencyConverter = objectMapper.readValue(result, CurrencyConverter.class);
		}
		catch (Exception e) {
			throw new CurrencyConverterException(e.getMessage());
		}
		return currencyConverter;
	}
}