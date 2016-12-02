/*
 * generated by Xtext 2.10.0
 */
package org.xtext.example.mydsl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.example.mydsl.playlist.MediaFile;
import org.xtext.example.mydsl.playlist.Playlist;
import org.xtext.example.mydsl.playlist.PlaylistPackage;
import org.xtext.example.mydsl.services.PlaylistGrammarAccess;

@SuppressWarnings("all")
public class PlaylistSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private PlaylistGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == PlaylistPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case PlaylistPackage.MEDIA_FILE:
				sequence_MediaFile(context, (MediaFile) semanticObject); 
				return; 
			case PlaylistPackage.PLAYLIST:
				sequence_Playlist(context, (Playlist) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     MediaFile returns MediaFile
	 *
	 * Constraint:
	 *     location=STRING
	 */
	protected void sequence_MediaFile(ISerializationContext context, MediaFile semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PlaylistPackage.Literals.MEDIA_FILE__LOCATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PlaylistPackage.Literals.MEDIA_FILE__LOCATION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMediaFileAccess().getLocationSTRINGTerminalRuleCall_0(), semanticObject.getLocation());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Playlist returns Playlist
	 *
	 * Constraint:
	 *     vids+=MediaFile+
	 */
	protected void sequence_Playlist(ISerializationContext context, Playlist semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
