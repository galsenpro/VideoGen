/*
 * generated by Xtext
 */
package org.xtext.example.mydsl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.example.mydsl.services.VideoGenGrammarAccess;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGenInformation;
import org.xtext.example.mydsl.videoGen.VideoGenPackage;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;

@SuppressWarnings("all")
public class VideoGenSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private VideoGenGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == VideoGenPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case VideoGenPackage.ALTERNATIVE_VIDEO_SEQ:
				sequence_AlternativeVideoSeq(context, (AlternativeVideoSeq) semanticObject); 
				return; 
			case VideoGenPackage.MANDATORY_VIDEO_SEQ:
				sequence_MandatoryVideoSeq(context, (MandatoryVideoSeq) semanticObject); 
				return; 
			case VideoGenPackage.OPTIONAL_VIDEO_SEQ:
				sequence_OptionalVideoSeq(context, (OptionalVideoSeq) semanticObject); 
				return; 
			case VideoGenPackage.VIDEO_DESCRIPTION:
				sequence_VideoDescription(context, (VideoDescription) semanticObject); 
				return; 
			case VideoGenPackage.VIDEO_GEN_INFORMATION:
				sequence_VideoGenInformation(context, (VideoGenInformation) semanticObject); 
				return; 
			case VideoGenPackage.VIDEO_GENERATOR_MODEL:
				sequence_VideoGeneratorModel(context, (VideoGeneratorModel) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (videoid=ID? videodescs+=VideoDescription+)
	 */
	protected void sequence_AlternativeVideoSeq(EObject context, AlternativeVideoSeq semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     description=VideoDescription
	 */
	protected void sequence_MandatoryVideoSeq(EObject context, MandatoryVideoSeq semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, VideoGenPackage.Literals.MANDATORY_VIDEO_SEQ__DESCRIPTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VideoGenPackage.Literals.MANDATORY_VIDEO_SEQ__DESCRIPTION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0(), semanticObject.getDescription());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     description=VideoDescription
	 */
	protected void sequence_OptionalVideoSeq(EObject context, OptionalVideoSeq semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, VideoGenPackage.Literals.OPTIONAL_VIDEO_SEQ__DESCRIPTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VideoGenPackage.Literals.OPTIONAL_VIDEO_SEQ__DESCRIPTION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOptionalVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0(), semanticObject.getDescription());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (videoid=ID? location=STRING (duration=INT? probability=INT? size=INT? description=STRING?)?)
	 */
	protected void sequence_VideoDescription(EObject context, VideoDescription semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (authorName=STRING version=STRING? creationDate=STRING?)
	 */
	protected void sequence_VideoGenInformation(EObject context, VideoGenInformation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (information=VideoGenInformation? videoseqs+=VideoSeq+)
	 */
	protected void sequence_VideoGeneratorModel(EObject context, VideoGeneratorModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
