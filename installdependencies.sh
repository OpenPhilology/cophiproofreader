#!/bin/bash
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/primefaces-3.4.2.jar -DgroupId=org.primefaces -DartifactId=primefaces -Dversion=3.4.2
mv jars/primefaces-3.4.2.jar repo/org/primefaces/primefaces/3.4.2/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/commons-lang-2.6.jar -DgroupId=commons-lang -DartifactId=commons-lang -Dversion=2.6
mv jars/commons-lang-2.6.jar repo/commons-lang/commons-lang/2.6/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/jdom2-2.0.4.jar -DgroupId=org.jdom -DartifactId=jdom2 -Dversion=2.0.4
mv jars/jdom2-2.0.4.jar repo/org/jdom/jdom2/2.0.4/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/jstl-1.2.jar -DgroupId=jstl -DartifactId=jstl -Dversion=1.2
mv jars/jstl-1.2.jar repo/jstl/jstl/1.2/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/junit-4.10.jar -DgroupId=junit -DartifactId=junit -Dversion=4.10
mv jars/junit-4.10.jar repo/junit/junit/4.10/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/exist-2.0.jar -DgroupId=exist -DartifactId=exist -Dversion=2.0
mv jars/exist-2.0.jar repo/exist/exist/2.0/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/xmldb-2.0.jar -DgroupId=xmldb -DartifactId=xmldb -Dversion=2.0
mv jars/xmldb-2.0.jar repo/xmldb/xmldb/2.0/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/antlr-2.7.7.jar -DgroupId=antlr -DartifactId=antlr -Dversion=2.7.7
mv jars/antlr-2.7.7.jar repo/antlr/antlr/2.7.7/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/commons-collections-3.2.1.jar -DgroupId=commons-collections -DartifactId=commons-collections -Dversion=3.2.1
mv jars/commons-collections-3.2.1.jar repo/commons-collections/commons-collections/3.2.1/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/commons-logging-1.1.1.jar -DgroupId=commons-logging -DartifactId=commons-logging -Dversion=1.1.1
mv jars/commons-logging-1.1.1.jar repo/commons-logging/commons-logging/1.1.1/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/commons-pool-1.6.jar -DgroupId=commons-pool -DartifactId=commons-pool -Dversion=1.6
mv jars/commons-pool-1.6.jar repo/commons-pool/commons-pool/1.6/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/log4j-1.2.17.jar -DgroupId=log4j -DartifactId=log4j -Dversion=1.2.17
mv jars/log4j-1.2.17.jar repo/log4j/log4j/1.2.17/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/exist-index-lucene-2.0.jar -DgroupId=exist -DartifactId=exist-index-lucene -Dversion=2.0
mv jars/exist-index-lucene-2.0.jar repo/exist/exist-index-lucene/2.0/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/exist-index-ngram-2.0.jar -DgroupId=exist -DartifactId=exist-index-ngram -Dversion=2.0
mv jars/exist-index-ngram-2.0.jar repo/exist/exist-index-ngram/2.0/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/exist-modules-2.0.jar -DgroupId=exist -DartifactId=exist-modules -Dversion=2.0
mv jars/exist-modules-2.0.jar repo/exist/exist-modules/2.0/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/exist-versioning-2.0.jar -DgroupId=exist -DartifactId=exist-versioning -Dversion=2.0
mv jars/exist-versioning-2.0.jar repo/exist/exist-versioning/2.0/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/jta-1.1.jar -DgroupId=jta -DartifactId=jta -Dversion=1.1
mv jars/jta-1.1.jar repo/jta/jta/1.1/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/lucene-analyzers-3.6.1.jar -DgroupId=lucene -DartifactId=lucene-analyzers -Dversion=3.6.1
mv jars/lucene-analyzers-3.6.1.jar repo/lucene/lucene-analyzers/3.6.1/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/lucene-core-3.6.1.jar -DgroupId=lucene -DartifactId=lucene-core -Dversion=3.6.1
mv jars/lucene-core-3.6.1.jar repo/lucene/lucene-core/3.6.1/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/lucene-queries-3.6.1.jar -DgroupId=lucene -DartifactId=lucene-queries -Dversion=3.6.1
mv jars/lucene-queries-3.6.1.jar repo/lucene/lucene-queries/3.6.1/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/pkg-repo-2.0.jar -DgroupId=pkg -DartifactId=pkg-repo -Dversion=2.0
mv jars/pkg-repo-2.0.jar repo/pkg/pkg-repo/2.0/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/quartz-2.1.6.jar -DgroupId=quartz -DartifactId=quartz -Dversion=2.1.6
mv jars/quartz-2.1.6.jar repo/quartz/quartz/2.1.6/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/slf4j-api-1.7.2.jar -DgroupId=slf4j -DartifactId=slf4j-api -Dversion=1.7.2
mv jars/slf4j-api-1.7.2.jar repo/slf4j/slf4j-api/1.7.2/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/slf4j-log4j12-1.7.2.jar -DgroupId=slf4j -DartifactId=slf4j-log4j12 -Dversion=1.7.2
mv jars/slf4j-log4j12-1.7.2.jar repo/slf4j/slf4j-log4j12/1.7.2/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/sunxacml-1.2.jar -DgroupId=sunxacml -DartifactId=sunxacml -Dversion=1.2
mv jars/sunxacml-1.2.jar repo/sunxacml/sunxacml/1.2/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/xmlrpc-client-3.1.3.jar -DgroupId=xmlrpc -DartifactId=xmlrpc-client -Dversion=3.1.3
mv jars/xmlrpc-client-3.1.3.jar repo/xmlrpc/xmlrpc-client/3.1.3/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/xmlrpc-common-3.1.3.jar -DgroupId=xmlrpc -DartifactId=xmlrpc-common -Dversion=3.1.3
mv jars/xmlrpc-common-3.1.3.jar repo/xmlrpc/xmlrpc-common/3.1.3/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/xmlrpc-server-3.1.3.jar -DgroupId=xmlrpc -DartifactId=xmlrpc-server -Dversion=3.1.3
mv jars/xmlrpc-server-3.1.3.jar repo/xmlrpc/xmlrpc-server/3.1.3/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/ws-commons-util-1.0.2.jar -DgroupId=ws-commons-util -DartifactId=ws-commons-util -Dversion=1.0.2
mv jars/ws-commons-util-1.0.2.jar repo/ws-commons-util/ws-commons-util/1.0.2/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/commons-io-2.4.jar -DgroupId=commons-io -DartifactId=commons-io -Dversion=2.4
mv jars/commons-io-2.4.jar repo/commons-io/commons-io/2.4/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/cglib-nodep-2.2.2.jar -DgroupId=cglib -DartifactId=cglib-nodep -Dversion=2.2.2
mv jars/cglib-nodep-2.2.2.jar repo/cglib/cglib-nodep/2.2.2/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/clj-ds-0.0.1.jar -DgroupId=clj -DartifactId=clj-ds -Dversion=0.0.1
mv jars/clj-ds-0.0.1.jar repo/clj/clj-ds/0.0.1/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/excalibur-cli-1.0.jar -DgroupId=excalibur-cli -DartifactId=excalibur-cli -Dversion=1.0
mv jars/excalibur-cli-1.0.jar repo/excalibur-cli/excalibur-cli/1.0/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/gnu-crypto-2.0.1-min.jar -DgroupId=gnu -DartifactId=gnu-crypto -Dversion=2.0.1-min
mv jars/gnu-crypto-2.0.1-min.jar repo/gnu/gnu-crypto/2.0.1-min/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/jackson-core-2.1.2.jar -DgroupId=jackson -DartifactId=jackson-core -Dversion=2.1.2
mv jars/jackson-core-2.1.2.jar repo/jackson/jackson-core/2.1.2/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/jEdit-syntax-1.0.jar -DgroupId=jEdit -DartifactId=jEdit-syntax -Dversion=1.0
mv jars/jEdit-syntax-1.0.jar repo/jEdit/jEdit-syntax/1.0/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/jline-0.9.94.jar -DgroupId=jline -DartifactId=jline -Dversion=0.9.94
mv jars/jline-0.9.94.jar repo/jline/jline/0.9.94/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/resolver-1.2.jar -DgroupId=resolver -DartifactId=resolver -Dversion=1.2
mv jars/resolver-1.2.jar repo/resolver/resolver/1.2/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/saxonhe-9.2.1.5.jar -DgroupId=saxonhe -DartifactId=saxonhe -Dversion=9.2.1.5
mv jars/saxonhe-9.2.1.5.jar repo/saxonhe/saxonhe/9.2.1.5/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/serializer-2.7.1.jar -DgroupId=serializer -DartifactId=serializer -Dversion=2.7.1
mv jars/serializer-2.7.1.jar repo/serializer/serializer/2.7.1/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/xalan-2.7.1.jar -DgroupId=xalan -DartifactId=xalan -Dversion=2.7.1
mv jars/xalan-2.7.1.jar repo/xalan/xalan/2.7.1/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/xercesImpl-2.11.0.jar -DgroupId=xerces -DartifactId=xercesImpl -Dversion=2.11.0
mv jars/xercesImpl-2.11.0.jar repo/xerces/xercesImpl/2.11.0/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/xml-apis-1.4.01.jar -DgroupId=xml-apis -DartifactId=xml-apis -Dversion=1.4.01
mv jars/xml-apis-1.4.01.jar repo/xml-apis/xml-apis/1.4.01/
mvn install:install-file -DlocalRepositoryPath=repo -DcreateChecksum=true -Dpackaging=jar -Dfile=jars/javaee-web-api-6.0.jar -DgroupId=javax -DartifactId=javaee-web-api -Dversion=6.0
mv jars/javaee-web-api-6.0.jar repo/javax/javaee-web-api/6.0/