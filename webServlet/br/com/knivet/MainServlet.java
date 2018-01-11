package br.com.knivet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import escavadorProcesso.ChamarEscavador;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import outputs.email.EmailPost;

public class MainServlet extends HttpServlet{
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
//		StringBuilder json = new StringBuilder();
//		BufferedReader reader = req.getReader();
//		String linha;
//		while( (linha = reader.readLine()) != null ){
//		    json.append(linha);
//		}
//		System.out.println("lendo json"+json.toString());
		ChamarEscavador escavador = new ChamarEscavador();
		escavador.run();
    }
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{	
//		StringBuilder json = new StringBuilder();
//		BufferedReader reader = req.getReader();
//		String linha;
//		while( (linha = reader.readLine()) != null ){
//		    json.append(linha);
//		}
//		System.out.println("lendo json"+json.toString());
		ChamarEscavador escavador = new ChamarEscavador();
		escavador.run();
	}
}