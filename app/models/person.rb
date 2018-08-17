class Person < Annotation
  include Neo4j::ActiveNode

  has_many :out, :annotations, type: :CREATES

end
