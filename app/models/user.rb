class User 
  include Neo4j::ActiveNode
  property :name, type: String
  property :email, type: String
  property :orcid, type: String

  has_one :in, :owner, type: :IS_SAME_AS, model_class: :Person

end
