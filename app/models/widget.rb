class Widget
  include Neo4j::ActiveNode
  property :description, type: String
  property :predicate, type: String
  property :timestamp, type: DateTime

  has_one :in, :creator, type: :CREATED_BY, model_class: :Person
  has_many :in, :target, type: :IS_ANNOTATING, model_class: :Widget
  has_many :out, :body, type: :ANNOTATES, model_class: :Widget
end
