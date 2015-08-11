package utility;

import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.Document;

public class ActivatedHyperlinkListener implements HyperlinkListener{

	 JEditorPane editorPane;

	  public ActivatedHyperlinkListener(JEditorPane editorPane) {
	    this.editorPane = editorPane;
	  }

	  public void hyperlinkUpdate(HyperlinkEvent hyperlinkEvent) {
	    HyperlinkEvent.EventType type = hyperlinkEvent.getEventType();
	    final URL url = hyperlinkEvent.getURL();
	    if (type == HyperlinkEvent.EventType.ENTERED) {
	      System.out.println("URL: " + url);
	    } else if (type == HyperlinkEvent.EventType.ACTIVATED) {
	      System.out.println("Activated");

	      Document doc = editorPane.getDocument();
	      try {
	        editorPane.setPage(url);
	      } catch (IOException ioException) {
	        System.out.println("Error following link, Invalid link");
	        editorPane.setDocument(doc);
	      }
	    }
	  }
	}


