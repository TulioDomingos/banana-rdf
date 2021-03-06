package org.w3.banana

import org.w3.banana.io.SparqlQueryResultsReader
import io._
import scala.util.Try

trait RDFModule {

  type Rdf <: RDF

}

trait RDFOpsModule extends RDFModule {

  implicit val ops: RDFOps[Rdf]

}

trait RecordBinderModule extends RDFModule {

  implicit val recordBinder: binder.RecordBinder[Rdf]

}

trait SparqlOpsModule extends RDFModule {

  implicit val sparqlOps: SparqlOps[Rdf]

}

trait SparqlGraphModule extends RDFModule {

  implicit val sparqlGraph: SparqlEngine[Rdf, Rdf#Graph]

}

trait SparqlHttpModule extends RDFModule {

  import java.net.URL

  implicit val sparqlHttp: SparqlEngine[Rdf, URL]

}

trait RDFXMLReaderModule extends RDFModule {

  implicit val rdfXMLReader: RDFReader[Rdf, Try, RDFXML]

}

trait TurtleReaderModule extends RDFModule {

  implicit val turtleReader: RDFReader[Rdf, Try, Turtle]

}

trait NTriplesReaderModule extends RDFModule {
  implicit val ntriplesReader: RDFReader[Rdf, Try, NTriples]
}

/* CurrentJsonLDReader contains all three reader types. If needed
 * these could be split out.
 */
trait JsonLDReaderModule extends RDFModule {

  implicit val jsonldReader: RDFReader[Rdf, Try, JsonLd]

}

/* CurrentJsonLDReader contains all three writer types. If needed
 * these could be split out.
 */
trait JsonLDWriterModule extends RDFModule {
  implicit val jsonldCompactedWriter: RDFWriter[Rdf, Try, JsonLdCompacted]

  implicit val jsonldExpandedWriter: RDFWriter[Rdf, Try, JsonLdExpanded]

  implicit val jsonldFlattenedWriter: RDFWriter[Rdf, Try, JsonLdFlattened]
}

trait ReaderSelectorModule extends RDFModule {

  implicit val readerSelector: ReaderSelector[Rdf, Try]

}

trait RDFXMLWriterModule extends RDFModule {

  implicit val rdfXMLWriter: RDFWriter[Rdf, Try, RDFXML]

}

trait TurtleWriterModule extends RDFModule {

  implicit val turtleWriter: RDFWriter[Rdf, Try, Turtle]

}

trait WriterSelectorModule extends RDFModule {

  implicit val writerSelector: RDFWriterSelector[Rdf, Try]

}

trait JsonSolutionsWriterModule extends RDFModule {

  implicit val jsonSolutionsWriter: SparqlSolutionsWriter[Rdf, SparqlAnswerJson]

}

trait XmlSolutionsWriterModule extends RDFModule {

  implicit val xmlSolutionsWriter: SparqlSolutionsWriter[Rdf, SparqlAnswerXml]

}

trait SparqlSolutionsWriterSelectorModule extends RDFModule {

  implicit val sparqlSolutionsWriterSelector: SparqlSolutionsWriterSelector[Rdf]

}

trait JsonQueryResultsReaderModule extends RDFModule {

  implicit val jsonQueryResultsReader: SparqlQueryResultsReader[Rdf, SparqlAnswerJson]

}

trait XmlQueryResultsReaderModule extends RDFModule {

  implicit val xmlQueryResultsReader: SparqlQueryResultsReader[Rdf, SparqlAnswerXml]

}
